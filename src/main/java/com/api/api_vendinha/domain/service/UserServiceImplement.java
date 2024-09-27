package com.api.api_vendinha.domain.service;

import com.api.api_vendinha.domain.dto.request.UserRequestDto;
import com.api.api_vendinha.domain.dto.response.UserResponseDto;
import com.api.api_vendinha.domain.entity.Product;
import com.api.api_vendinha.domain.entity.Sale;
import com.api.api_vendinha.domain.entity.User;
import com.api.api_vendinha.infrastructure.repository.ProductRepository;
import com.api.api_vendinha.infrastructure.repository.SaleRepository;
import com.api.api_vendinha.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserServiceInterface {

    // variável do userRepository para persistência de dados de usuários
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;

    // Construtor p injeção de depend do UserRepository
    @Autowired
    public UserServiceImplement(UserRepository userRepository, ProductRepository productRepository, SaleRepository saleRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
    }

    // Método POST
    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {

        // Cria nova instância de User
        User user = new User();

        //Define o nome do usuário a partir do Dto de request do usuário
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setCpf_cnpj(userRequestDto.getCpf_cnpj());
        user.setIs_active(userRequestDto.getIs_active());

        // Salva o usuário no bd e obtém a entidade persistida com o id gerado
        User savedUser = userRepository.save(user);

        // Converte numa collection -> coleção de lista de todos os objetos criados a partir de cada atributo
        List<Product> products = userRequestDto.getProductRequestDto().stream().map(
                dto -> {
                    Product product = new Product();

                    product.setUser(savedUser);
                    product.setName(dto.getName());
                    product.setQuantity(dto.getQuantity());
                    product.setPrice(dto.getPrice());
                    product.setIsActive(dto.getIsActive());

                    return product;
        }).collect(Collectors.toList());

        // agora ele pode salvar a lista toda de produtos
        productRepository.saveAll(products);

        List<Sale> sales =  userRequestDto.getSaleRequestDto().stream().map(dto -> {
            Sale sale = new Sale();

            sale.setUser(savedUser);
            //sale.setProduct()
            sale.setQuantity(dto.getQuantity());
            sale.setPrice(dto.getPrice());

            return sale;
        }).collect(Collectors.toList());

        // agora ele pode salvar a lista toda de vendas
        saleRepository.saveAll(sales);

        // Cria um DTO de resposta com as infos do usuário salvo
        return getUserDto(savedUser);
    }
    //stream() -> api com n métodos, inclusive map()
    //map() -> percorrer uma lista com indexação de novos objetos dessa lista sem perder referencias(index)
    //.collect(Collectors.toList()) -> transforma em collector

    // Método UPDATE
    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {

        // Verifica se o usuário existe
        User userExists = userRepository.findById(id).orElseThrow();

        userExists.setName(userRequestDto.getName());
        userExists.setEmail(userRequestDto.getEmail());
        userExists.setPassword(userRequestDto.getPassword());
        userExists.setCpf_cnpj(userRequestDto.getCpf_cnpj());
        userExists.setIs_active(userRequestDto.getIs_active());

        // Atualiza os dados e salva no bd
        User savedUser = userRepository.save(userExists);

        return getUserDto(savedUser);
    }

    // Método GET
    @Override
    public UserResponseDto getUser(Long id) {

        // Verifica se o user existe
        User userExists = userRepository.findById(id).orElseThrow();

        // Retorna o DTO com as infos o usuário encontrado
        return getUserDto(userExists);
    }

    @Override
    public void deleteUser(Long id) {
        User userExists = userRepository.findById(id).orElseThrow();

        userRepository.deleteById(userExists.getId());
    }

    // Função p retornar o userResponseDto
    private UserResponseDto getUserDto(User user) {

        // Cria um Dto de resposta com as infos do usuário salvo
        UserResponseDto userResponseDto = new UserResponseDto();
                            // novo obj do tipo UserResponseDto

        // Seta os atributos da resposta do Dto
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setCpf_cnpj(user.getCpf_cnpj());
        userResponseDto.setIs_active(user.getIs_active());
            //não devolver a senha pro usuário

        // Retorna o Dto com as infos do usuário salvo
        return userResponseDto;
    }
}