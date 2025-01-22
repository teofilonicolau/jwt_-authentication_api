# JWT Authentication API

## Descrição

Essa API foi desenvolvida para realizar autenticação de usuários utilizando JWT (JSON Web Token). A API é construída com Spring Boot, Spring Security, e utiliza H2 Database para armazenamento de dados temporários.

## Funcionalidades

- **Registro de Usuário**: Permite que novos usuários se registrem na plataforma.
- **Login de Usuário**: Autentica os usuários e gera um token JWT.
- **Acesso Protegido**: Endpoints protegidos que requerem um token JWT válido para acesso.

## Endpoints Principais

- `POST /auth/register`: Registra um novo usuário.
- `POST /auth/login`: Autentica um usuário e retorna um token JWT.
- ![image](https://github.com/user-attachments/assets/0bbfd331-d144-4fa8-9a72-75a3cf83f7fb)


## Tecnologias Utilizadas

- **Spring Boot**: Criação da aplicação de forma rápida e produtiva.
- **Spring Security**: Implementação de autenticação e autorização.
- **JWT**: Autenticação baseada em token.
- **H2 Database**: Banco de dados em memória para fins de teste.
- **Lombok**: Redução do código boilerplate.
- **Swagger**: Documentação da API.

## Problemas Conhecidos

1. **Erro 403 ao Logar**: Atualmente, ao tentar fazer login, um erro 403 (Forbidden) é retornado. Isso indica que há problemas na autenticação, possivelmente em algum aspecto do filtro JWT ou configuração de segurança.(resolvido)
2. **CustomUserDetailsService**: Definimos esta classe para implementar a interface UserDetailsService e carregar os detalhes do usuário. Garantimos que o UserDetails customizado esteja 
sendo retornado corretamente.

**UserService**: Removemos a implementação do método loadUserByUsername, evitando duplicidade e conflito com CustomUserDetailsService.

**AuthController**: Ajustamos o método de login para incluir blocos try-catch para capturar exceções e detalhar mensagens de erro no processo de autenticação.

**SecurityConfig**: Certificamos de que o AuthenticationManager esteja configurado corretamente para usar o serviço de UserDetails customizado.

**Logging Adicional**: Adicionamos logs detalhados antes e depois de etapas críticas para diagnóstico e depuração mais eficientemente
3. **Configuração do Swagger**: Certifique-se de que as URLs do Swagger estejam disponíveis sem autenticação para que a documentação esteja acessível.
![image](https://github.com/user-attachments/assets/81359aea-4eee-4cf9-aff1-374a4be7f086)
![image](https://github.com/user-attachments/assets/b935e8df-8173-489d-9ea2-83e24f03b536)
![image](https://github.com/user-attachments/assets/63e1507f-3480-4ec1-84d7-6870b47c006e)




## Como Contribuir

1. Clone o repositório:
   ```bash
   git clone https://github.com/teofilonicolau/jwt_-authentication_api.git
   ```
   
