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

หลังจากสร้าง Folder เสร็จ

### Step 1: เข้าเว็บ Spring Initializr

เปิด Browser แล้วเข้าไปที่เว็บนี้ครับ **[start.spring.io](https://start.spring.io/)**

### Step 2: ตั้งค่าโปรเจกต์สำหรับ `service-product`

* **Project:** เลือก `Maven`
* **Language:** เลือก `Java`
* **Spring Boot:** เลือกเวอร์ชันที่เป็นค่าเริ่มต้น (มักจะเป็น `3.4.x` หรือ `3.3.x` ที่ไม่มีคำว่า SNAPSHOT)
* **Project Metadata:**
* Group: `com.cafepos`
* Artifact: `service-product`
* Name: `service-product`
* Packaging: `Jar`
* Java: `17` หรือ `21`

### Step 3: เพิ่ม Dependencies (อาวุธประจำตัว)

**"ADD DEPENDENCIES"**
1. **Spring Web:** เอาไว้ทำ API (สร้าง Controller, รับ-ส่ง JSON)
2. **Spring Data JPA:** เอาไว้คุยกับ Database สั่งบันทึก/ดึงข้อมูลแบบไม่ต้องเขียน SQL เอง
3. **PostgreSQL Driver:** ตัวเชื่อมต่อที่ทำให้ Spring Boot คุยกับ DB ก้อนที่เราเพิ่งสร้างได้
4. **Lombok:** ตัวช่วยลดการเขียนโค้ดที่ซ้ำซาก (พวก Getter/Setter)

### Step 4: ดาวน์โหลดและนำมาใส่ในโปรเจกต์ของเรา

1. กดปุ่ม **GENERATE** ด้านล่างสุด (มันจะโหลดไฟล์ `service-product.zip` ลงมาที่เครื่องคุณ)
2. ให้ทำการ **แตกไฟล์ (Extract)** ไฟล์ zip นั้นออกมา
3. ให้ **ก๊อปปี้ "ของทั้งหมด" ที่อยู่ข้างในนั้น** ไปวางใส่ในโฟลเดอร์ `service-product` ของโปรเจกต์ `cafe-pos-microservices`


# My Microservices Portfolio

A complete microservices architecture project demonstrating backend and frontend integration.

# Cafe POS Microservices
ระบบหลังบ้าน (Backend) สำหรับจัดการร้านขายเครื่องดื่มและระบบสะสมแต้ม พัฒนาด้วยสถาปัตยกรรม Microservices

## เครื่องมือและเทคโนโลยีที่ใช้
* **Backend Framework:** Java Spring Boot
* **Frontend Framework:** React
* **Database:** PostgreSQL (รันผ่าน Docker Compose)

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


# 1. เริ่มต้นระบบ Git (ถ้าเคยรันตอนแรกไปแล้ว มันจะบอกว่า Reinitialized ก็ไม่เป็นไรครับ)
git init

# 2. กวาดไฟล์ทั้งหมดลงกล่อง (ไม่ต้องห่วง ยาม .gitignore จะเตะไฟล์ขยะทิ้งให้เอง)
git add .

# 3. ลองเช็คดูว่ามีไฟล์อะไรลงกล่องบ้าง (จะเป็นตัวหนังสือสีเขียวๆ)
git status

# 4. ปิดผนึกกล่อง (ตั้งชื่อ Commit ให้ดูโปร)
git commit -m "feat: add docker-compose, init-db and service-product base"

# 5. เปลี่ยนชื่อสาขาหลักเป็น main
git branch -M main

# 6. เชื่อมกับ GitHub ของคุณ (เปลี่ยนตรง YOUR_USERNAME เป็นชื่อของคุณนะครับ)
git remote add origin https://github.com/Wayo2021/cafe-pos-microservices-full-stack.git
# (ถ้าเคยเชื่อมไปแล้ว มันจะฟ้องว่า remote origin already exists ให้ข้ามบรรทัดนี้ไปเลยครับ)

# 7. ดันขึ้น GitHub เลย!
git push -u origin main


### พิมพ์คำสั่งดันโค้ดขึ้น GitHub
**4 ขั้นตอนประจำวัน (Daily Git Workflow) :**
git status
git add .
git commit -m "comment or explain"
git push