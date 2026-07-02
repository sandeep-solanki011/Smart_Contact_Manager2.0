# 📇 Smart Contact Manager 2.0

A full-stack Contact Management Web Application built using **Spring Boot**, **Spring Security**, **Hibernate (JPA)**, **MySQL**, and **Thymeleaf**.

The application allows users to securely manage their personal contacts with authentication, profile management, and complete CRUD functionality.

---

## 🚀 Features

- User Registration & Login
- Secure Authentication using Spring Security
- Google OAuth2 Login
- GitHub OAuth2 Login
- Add New Contacts
- Update Contacts
- Delete Contacts
- View All Contacts
- Search Contacts
- Upload Contact Profile Images
- User Profile Management
- Password Encryption using BCrypt
- Responsive User Interface
- Server-side Validation
- Secure Session Management

---

# 🛠 Tech Stack

## Backend
- Java 21
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate

## Frontend
- HTML5
- CSS3
- JavaScript
- Thymeleaf
- Tailwind CSS
- Flowbite

## Database
- MySQL

## Authentication
- Spring Security
- Google OAuth2
- GitHub OAuth2

## Build Tool
- Maven

---

# 📂 Project Structure

```text
Smart_Contact_Manager2.0
│── src
│   ├── main
│   │   ├── java
│   │   ├── resources
│   │   │   ├── static
│   │   │   ├── templates
│   │   │   ├── application.properties
│   │   │   └── application-local.properties
│── pom.xml
│── README.md
```

---

# ⚙️ Installation

## Clone the Repository

```bash
git clone https://github.com/sandeep-solanki011/Smart_Contact_Manager2.0.git
```

## Move to Project Folder

```bash
cd Smart_Contact_Manager2.0
```

## Create MySQL Database

```sql
CREATE DATABASE scm;
```

## Configure Database

Update your `application-local.properties` file.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/scm
spring.datasource.username=root
spring.datasource.password=your_password
```

## Configure OAuth Credentials

```properties
spring.security.oauth2.client.registration.google.client-id=
spring.security.oauth2.client.registration.google.client-secret=

spring.security.oauth2.client.registration.github.client-id=
spring.security.oauth2.client.registration.github.client-secret=
```

## Run the Project

```bash
mvn spring-boot:run
```

Or run:

```
ScmApplication.java
```

---

# 🔄 Application Flow

```text
User
   │
   ▼
Spring Security
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
Hibernate (JPA)
   │
   ▼
MySQL Database
```

---

# 📈 Future Enhancements

- Email Verification
- Forgot Password
- Dark Mode
- Import Contacts (CSV)
- Export Contacts (PDF/Excel)
- Favorite Contacts
- Notifications

---

# 👨‍💻 Author

**Sandeep Solanki**

Java Full Stack Developer

### Skills

- Java
- Spring Boot
- Hibernate
- Spring Security
- MySQL
- HTML
- CSS
- JavaScript
- React.js
- Git
- GitHub

---

# 🤝 Contributing

1. Fork the repository

2. Create a new branch

```bash
git checkout -b feature-name
```

3. Commit your changes

```bash
git commit -m "Add new feature"
```

4. Push the branch

```bash
git push origin feature-name
```

5. Open a Pull Request.

---

# ⭐ Support

If you found this project helpful, please give it a ⭐ on GitHub.

---

# 📄 License

This project is developed for learning and educational purposes.
