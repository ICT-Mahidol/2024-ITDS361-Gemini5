# 🌌 Gemini-5 Project Setup Guide

## 🔧 การตั้งค่า H2 Database

แก้ไข path สำหรับเก็บข้อมูล **H2 Database* ในไฟล์ `application.properties`
```
backend/src/main/resources/application.properties
```

จากนั้นแก้ไขบรรทัดนี้เป็น path ที่ต้องการ:
```
spring.datasource.url=jdbc:h2:file:D:/gemini-5/db/gemini5.db
```

> 💡 เปลี่ยน path ได้ตามที่คุณต้องการ เช่น `D:/gemini-5/db/gemini5.db` 

## 🚀 วิธีการรัน OCS (Spring Boot)

1. เข้าไปยังโฟลเดอร์ `SpringBootOCS`:

   ```bash
   cd SpringBootOCS
   ```

2. Run OCS :

   ```bash
   ./gradlew bootRun
   ```

---

## 🚀 วิธีการรัน Backend (Spring Boot)

1. เข้าไปยังโฟลเดอร์ `backend`:

   ```bash
   cd backend
   ```

2. Run App ฝั่ง backend ด้วย Gradle:

   ```bash
   ./gradlew bootRun
   ```

---

## 🖥️ วิธีการรัน Frontend (React)

1. เข้าไปยังโฟลเดอร์ `frontend`:

   ```bash
   cd frontend
   ```

2. ติดตั้ง dependencies:

   ```bash
   npm install
   ```

3. Run App ฝั่ง frontend:

   ```bash
   npm start
   ```

> 🌐 React app จะเปิดที่ `http://localhost:3000` โดยอัตโนมัติ
