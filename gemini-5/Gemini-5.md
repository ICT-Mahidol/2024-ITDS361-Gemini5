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
>
> ------------------------------------------------------------

## 🧱 Design Pattern: Facade

โปรเจ็คนี้มีการใช้ **Facade Design Pattern** เพื่อจัดการการสื่อสารกับ OCS (Observation Control System) อย่างมีประสิทธิภาพ โดยได้มีการสร้างคลาส `GeminiFacade` เพื่อเป็นตัวกลางในการเรียกใช้งาน `OCSServiceClient` ซึ่งช่วยลด **coupling** และทำให้โค้ด **อ่านง่ายและดูแลรักษาได้ง่ายขึ้น**

- คลาส `GeminiFacade` เป็นจุดรวมการเชือมต่อกับ OCS ทำให้โค้ดอ่านง่ายขึ้นและการเปลี่ยนแปลง logic ของ OCS ทำได้ในที่เดียว
- Service อื่น ๆ ไม่ต้องรู้รายละเอียดการทำงานภายในของ `OCSServiceClient` ว่าทำงานอย่างไร 
- ช่วยให้การแก้ไขหรือปรับปรุงโปรเจ็คในอนาคต จะไม่กระทบกับ service ที่ใช้งานอยู่ 

### หน้าที่ของแต่ละคลาส

| Class          | Responsibility                                                             |
|------------------|-----------------------------------------------------------------------------|
| `OCSServiceClient` | รับผิดชอบการสื่อสาร HTTP กับระบบ OCS โดยตรง                             |
| `GeminiFacade`     | รวม business logic ที่เกี่ยวข้องกับ OCS และเป็น interface สำหรับ service อื่น ๆ |


> 💡 ตัวอย่างการใช้งาน: แทนที่ `SciencePlanService` จะเรียกใช้ `OCSServiceClient` โดยตรงหลาย method ก็สามารถเรียก `GeminiFacade` method เดียวที่ encapsulate การทำงานไว้ทั้งหมด
