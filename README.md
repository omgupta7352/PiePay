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

- **Backend:** Java, Spring Boot, Spring Data JPA, H2/MySQL, Local File System  
- **Frontend:** React, React Router, Axios, Tailwind CSS  
- **Build:** Maven (backend), npm (frontend)  
- **Version Control:** Git, GitHub  

---

## Architecture

```
┌─────────┐          ┌──────────────┐   HTTP   ┌─────────────┐
│Browser  │◀────────▶│React Frontend│◀────────▶│Spring Boot│
│ (UI)    │   REST   │ (Tailwind)   │   API    │  Backend    │
└─────────┘          └──────────────┘          └─────────────┘
```

## UML Diagram

```
+-------------------+         +------------------------+
|   FileController  |         |    FileService         |
|-------------------|         |------------------------|
| - fileService     |<>------>| - fileRepository       |
|                   |         | - storagePath          |
| + uploadFile()    |         | + uploadFile()         |
| + getAllFiles()   |         | + getAllFiles()        |
| + downloadFile()  |         | + downloadFile()       |
| + deleteFile()    |         | + deleteFile()         |
+-------------------+         +------------------------+
        |
        | Uses
        v
+---------------------+
|     FileEntity      |
|---------------------|
| - id                |
| - filename          |
| - originalFilename  |
| - contentType       |
| - size              |
| - uploadTime        |
+---------------------+

+-------------------------+
|     FileRepository      |
|-------------------------|
| extends JpaRepository   |
| + findByFilename()      |
+-------------------------+

Frontend ↔ REST API ↔ Backend ↔ Local File System
```

## Getting Started

### Prerequisites

* Java 17+
* Maven 3.6+
* MySQL 8 
* Git

### Backend Setup

1. Clone the repo:

   
bash
   git clone https://github.com/omgupta7352/Dropnest.git
   cd Dropnest/backend

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

## API Endpoints

| Method | Endpoint                   | Description           |
| ------ | -------------------------- | --------------------- |
| POST   | /api/files/upload          | Upload a file         |
| GET    | /api/files                 | List all files        |
| GET    | /api/files/{filename}      | Download file by Name  |
| GET    | /api/preview/{filename}    | Preview file (inline) |
| DELETE | /api/files/{id}            | Delete file by ID     |



## Usage

1. Navigate to http://localhost:3000
2. Drag & drop or click **Browse Files** to select a file
3. Click **Upload**
4. View your uploaded file in the list
5. Click **Preview** to view inline, **Download** to save locally, or **Delete** to remove

---

## Screenshots

![Home Page](dropnest1.png)
*Home page with upload & file list*

![Preview](dropnest2.png)
![Preview](dropnest3.png)
*Preview inline for text and images*

---

## Usage

1. Navigate to http://localhost:3000
2. Drag & drop or click **Browse Files** to select a file
3. Click **Upload**
4. View your uploaded file in the list
5. Click **Preview** to view inline, **Download** to save locally, or **Delete** to remove

## ✨ Future Improvements
If I had more time, I would:

✅ Add unit and integration tests.
✅ Add input validation and error handling for malformed payloads.
✅ Implement support for percentage-based discounts or more complex rules.
✅ Add authentication and authorization to secure the endpoints.
✅ Containerize with Docker and provide a docker-compose.yml for easy setup.


## Contributing

1. Fork the repository
2. Create a feature branch (git checkout -b feature/YourFeature)
3. Commit changes (git commit -m 'Add feature')
4. Push to branch (git push origin feature/YourFeature)
5. Open a Pull Request





