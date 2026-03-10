### Step 1: สร้าง Repository บน GitHub
Name: "cafe-pos-microservices-full-stack"

### Step 2: สร้างโครงสร้างโฟลเดอร์ในเครื่อง (ใช้ Command Line)
**1. สร้างโฟลเดอร์หลักและเข้าไปข้างใน:**
CMD
mkdir cafe-pos-microservice-full-stack
cd cafe-pos-microservice-full-stack

**2. เริ่มต้นระบบ Git:**
CMD
git init

**3. สร้างไฟล์หลักที่ :**
ส่วนอันนี้ผมสร้างไฟล์โดยการเอาเมาส์ไปคลิก New file, New folder

# My Microservices Portfolio

A complete microservices architecture project demonstrating backend and frontend integration.

## Project Structure (Monorepo)

- `/frontend` - React application (User Interface)
- `/api-gateway` - Spring Cloud Gateway (Entry point & Routing)
- `/service-user` - Spring Boot (Customer & Employee management)
- `/service-product` - Spring Boot (Drink catalog management)
- `/service-order` - Spring Boot (Order & transaction processing)
- `/service-loyalty` - Spring Boot (Reward & point redemption system)
- `/service-report` - Spring Boot (Daily sales reporting)

## Technologies Used
- React (Vite)
- Java Spring Boot 3 & Spring Cloud
- MySQL / PostgreSQL (Database per service)
- Docker & Docker Compose