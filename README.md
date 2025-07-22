# PiePay  🚀

Secure, lightweight Dropbox-like application for uploading, previewing, downloading, and managing files.

---

# 📌 Flipkart Offers Service

A Spring Boot backend service that:

- ✅ Stores Flipkart offers into a MySQL database via `POST /offer`  
- ✅ Returns the highest discount amount for a given bank (and optional payment instrument) via `GET /highest-discount`  
- ✅ **Bonus:** Supports filtering by `paymentInstrument` (e.g., CREDIT, EMI_OPTIONS)

---

## Table of Contents 🚀

1. [Features](#features)
2. [Tech Stack](#tech-stack)  
3. [Architecture](#architecture)
4. [UML Diagram](#uml-diagram)    
5. [Getting Started](#getting-started)  
   - [Prerequisites](#prerequisites)  
   - [Backend Setup](#backend-setup)  
   - [Frontend Setup](#frontend-setup)  
6. [API Endpoints](#api-endpoints)  
7. [Usage](#usage)  
8. [Screenshots](#screenshots)  
9. [Contributing](#contributing)  

---

## Features

- **File Upload:** Drag-and-drop or browse local files  
- **File Listing:** View all uploaded files in a clean interface  
- **File Preview:** Inline preview for images (`.png`, `.jpg`) and text (`.txt`, `.json`)  
- **Download:** Download files with a single click  
- **Delete:** Remove unwanted files permanently  
- **Type Restrictions:** Only `.txt`, `.png`, `.jpg`, `.jpeg`, `.json` allowed  
- **Responsive Design:** Mobile-friendly Tailwind CSS UI  

---

## Tech Stack

- **Backend:** Java, Spring Boot, Spring Data JPA, MySQL, Local File System  
- **Build:** Maven (backend), npm (frontend)  
- **Version Control:** Git, GitHub  

---

## Architecture

```
┌──────────────┐        REST API        ┌───────────────────┐        JPA / SQL        ┌───────────────┐
│   Client     │  ───────────────────▶  │ Spring Boot       │  ───────────────────▶  │   MySQL 8     │
│ (Postman or  │   (POST /offer, GET    │ Application       │   (OfferRepository)     │ Database      │
│  Browser)    │    /highest-discount)  │ (Controller +     │   persists/fetches      │ (offers table)│
│              │  ◀───────────────────  │ Service Layer)    │  ◀───────────────────  │               │
└──────────────┘                        └───────────────────┘                        └───────────────┘

```
---

## Getting Started

### Prerequisites

* Java 17+
* Maven 3.6+
* MySQL 8 
* Git

### Backend Setup

1. Clone the repo:

   
bash
```
   git clone https://github.com/omgupta7352/PiePay.git
   cd PiePay
```
2. Configure database in src/main/resources/application.properties:

   
properties
   ### MySQL
   ```
  spring.datasource.url=jdbc:mysql://localhost:3306/piepay?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
  spring.datasource.username=<your-mysql-username>
  spring.datasource.password=<your-mysql-password>
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true

```
3. Build and run:

   
bash
```
   mvn clean install
   mvn spring-boot:run
```
4. Backend runs at http://localhost:8080

---

## Screenshots

![Home Page](dropnest1.png)
*Home page with upload & file list*

![Preview](dropnest2.png)
![Preview](dropnest3.png)
*Preview inline for text and images*

---

## ⚡ Scaling GET `/highest-discount` to 1,000 RPS
To handle very high load:

- ✅ Add indexes on `bank_name` and `payment_instrument` columns to speed up lookups.
- ✅ Use **caching (e.g., Redis)** for frequently queried bank/payment combinations.
- ✅ Enable connection pooling (HikariCP) and tune pool size.
- ✅ Scale horizontally by running multiple instances behind a load balancer.

## ✨ Future Improvements
If I had more time, I would:

- ✅ Add unit and integration tests.
- ✅ Add input validation and error handling for malformed payloads.
- ✅ Implement support for percentage-based discounts or more complex rules.
- ✅ Add authentication and authorization to secure the endpoints.
- ✅ Containerize with Docker and provide a `docker-compose.yml` for easy setup.


## Contributing

1. Fork the repository
2. Create a feature branch (git checkout -b feature/YourFeature)
3. Commit changes (git commit -m 'Add feature')
4. Push to branch (git push origin feature/YourFeature)
5. Open a Pull Request





