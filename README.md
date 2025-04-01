# 🎟️ Movie Ticket Booking System

This is a **Spring Boot-based** Movie Ticket Booking System that allows users to browse movies, select seats, and book tickets seamlessly. The project is built using **Java, Spring Boot, and MySQL**.

## 🎥 Demo

- [Project Overview](https://youtu.be/Imqb8kQ6ZWQ)
- [Project Demo Video](https://youtu.be/Imqb8kQ6ZWQ)

## 🚀 Features

- User authentication and registration
- Browse available movies and showtimes
- Seat selection and booking
- Payment simulation
- Booking history and ticket management
- Admin panel for managing movies and showtimes

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot, Hibernate
- **Database:** MySQL
- **API Testing:** Postman
- **Build Tool:** Maven

## 📂 Project Structure

```
/src
  ├── main
  │   ├── java/com/otbs
  │   │   ├── controller  # Handles API requests
  │   │   ├── service     # Business logic implementation
  │   │   ├── repository  # Database interaction layer
  │   │   ├── model       # Entity classes for DB tables
  │   │   ├── dto         # Data Transfer Objects
  │   │   ├── config      # Application configurations
  │   ├── resources
  │       ├── application.properties # Database and server configurations
  │       ├── schema.sql  # Initial database schema setup
  ├── test  # Unit and integration tests
```

## 🔧 Setup Instructions

### Prerequisites

- Java 17+
- MySQL Database
- Maven
- Postman (optional, for API testing)

### Steps to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Tamal0018/TicketBookingApp.git
   
   ```

2. **Configure Database:**
   - Create a MySQL database:
     ```sql
     CREATE DATABASE ticket_booking;
     ```
   - Update `application.properties` with your database credentials.

3. **Build and Run the application:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Test APIs using Postman**
   - Base URL: `http://localhost:8080`
   - Example Endpoints:
     - `POST /users/register` - Register a new user
     - `POST /movies/add` - Add a new movie (Admin)
     - `GET /movies/all` - Fetch available movies
     - `POST /tickets/book` - Book a ticket
