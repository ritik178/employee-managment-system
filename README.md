# 🧑‍💼 Employee Management System

A simple yet functional backend REST API for managing employee data — built with **Spring Boot**. It supports full CRUD operations, bulk uploads, and salary-based filtering.

---

## 🚀 Features

- ➕ Add new employees
- 🧾 Fetch employee by ID
- 📋 Get all employees
- ✏️ Update employee data
- ❌ Delete employee by ID
- 📦 Bulk add employees
- 🔍 Filter employees by minimum salary

---

## ⚙️ Tech Stack

- **Backend**: Spring Boot
- **Database**: ( MySQL )
- **Build Tool**: Maven
- **REST Client**: Postman or integrated with React frontend (`http://localhost:3000`)

---

## 📂 API Endpoints

| Method | Endpoint                 | Description                       |
|--------|--------------------------|-----------------------------------|
| POST   | `/employee/add`          | Add a single employee             |
| POST   | `/employee/add/bulk`     | Add multiple employees at once    |
| GET    | `/employee/get/{id}`     | Get employee by ID                |
| GET    | `/employee/getall`       | Get all employees                 |
| PUT    | `/employee/update/{id}`  | Update an existing employee       |
| DELETE | `/employee/delete/{id}`  | Delete an employee by ID          |
| GET    | `/employee/filter`       | Filter employees by min salary    |

---

## 🛠️ Run Locally

```bash
# Clone the project
git clone https://github.com/your-username/employee-management-system

# Navigate to the project directory
cd employee-management-system

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
