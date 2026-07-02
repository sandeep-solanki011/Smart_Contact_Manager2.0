# 📇 Smart Contact Manager 2.0

A full-stack Contact Management Web Application built using **Spring Boot**, **Spring Security**, **Hibernate (JPA)**, **MySQL**, and **Thymeleaf**.

The application enables users to securely manage their contacts with authentication, profile management, contact image upload, and complete CRUD operations.

---

## 🚀 Features

- 🔐 User Registration & Login
- 🔒 Authentication with Spring Security
- 🌐 Google OAuth2 Login
- 🐙 GitHub OAuth2 Login
- ➕ Add New Contacts
- ✏️ Update Contacts
- 🗑️ Delete Contacts
- 📋 View All Contacts
- 🔍 Search Contacts
- 🖼️ Upload Contact Profile Images
- 👤 User Profile Management
- 🔑 Password Encryption using BCrypt
- ✅ Server-side Validation
- 📱 Responsive User Interface

---

## 🛠 Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate

### Frontend
- HTML5
- CSS3
- JavaScript
- Thymeleaf
- Tailwind CSS
- Flowbite

### Database
- MySQL

### Authentication
- Spring Security
- Google OAuth2
- GitHub OAuth2

### Build Tool
- Maven

---

## 📂 Project Structure

```text
Smart_Contact_Manager2.0
│── src
│── pom.xml
│── README.md
```

---

# ⚙️ Installation

## 1. Clone Repository

```bash
git clone https://github.com/sandeep-solanki011/Smart_Contact_Manager2.0.git
```

## 2. Move into Project

```bash
cd Smart_Contact_Manager2.0
```

## 3. Create MySQL Database

```sql
CREATE DATABASE scm;
```

## 4. Configure Database

Update your local configuration file (`application-local.properties`) with your own database credentials.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/scm
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
```

## 5. Configure OAuth Credentials

Add your own Google and GitHub OAuth credentials.

```properties
spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET

spring.security.oauth2.client.registration.github.client-id=YOUR_GITHUB_CLIENT_ID
spring.security.oauth2.client.registration.github.client-secret=YOUR_GITHUB_CLIENT_SECRET
```

> **Note:** Actual database credentials and OAuth secrets are intentionally excluded from this repository for security reasons.

## 6. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run:

```
ScmApplication.java
```

---

## 🔄 Application Flow

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
Hibernate
   │
   ▼
MySQL Database
```

---

## 📈 Future Enhancements

- Email Verification
- Forgot Password
- Dark Mode
- Import Contacts from CSV
- Export Contacts to PDF/Excel
- Favorite Contacts
- Notifications

---

## 👨‍💻 Author

**Sandeep Solanki**

Java Full Stack Developer

### Skills

- Java
- Spring Boot
- Spring Security
- Hibernate
- MySQL
- HTML
- CSS
- JavaScript
- React.js
- Git
- GitHub

---

## 🤝 Contributing

1. Fork this repository.
2. Create a new branch.

```bash
git checkout -b feature-name
```

3. Commit your changes.

```bash
git commit -m "Add new feature"
```

4. Push your branch.

```bash
git push origin feature-name
```

5. Create a Pull Request.

---

## ⭐ Support

If you found this project helpful, please consider giving it a ⭐ on GitHub.

---

## 📄 License

This project is developed for learning and educational purposes.
