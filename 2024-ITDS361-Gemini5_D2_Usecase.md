
![use_case](https://github.com/user-attachments/assets/3a004dc7-0c16-4520-a015-7262b2ec0776)

## **Precondition:** ทุกๆ Use case จะต้องล็อกอินเข้าสู่ระบบ

## **Astronomer**

1. ### **Use Case: Create a Science Plan**

**Description:** นักดาราศาสตร์สร้าง Science Plan สำหรับการสังเกตการณ์ทางดาราศาสตร์

2. ### **Use Case: Test the Science Plan with the Virtual Telescope Simulator**

**Description:** นักดาราศาสตร์ทดสอบ Science Plan โดยใช้เครื่องจำลองกล้องโทรทรรศน์

## **Astronomer - Observer**

1. ### **Use Case: Submit the Science Plan**

**Description:** นักดาราศาสตร์ส่ง Science Plan ให้ผู้สังเกตการณ์ตรวจสอบ

2. ### **Use Case: Consult**

**Description:** นักดาราศาสตร์และผู้สังเกตการณ์ปรึกษาหรือสื่อสารกันเกี่ยวกับการสังเกตการณ์ดาราศาสตร์ผ่านระบบ

## **Observer**

1. ### **Use Case: Verify and Validate the Science Plan**

**Description:** ผู้สังเกตการณ์รับ Science Plan มาตรวจสอบยืนยันความถูกต้องก่อนแปลงเป็นโปรแกรมสังเกตการณ์ ถ้ามีข้อผิดพลาดสามารถ reject Science Plan ได้

2. ### **Use Case: Convert Science Plan to Observing Program**

**Description:** ผู้สังเกตการณ์แปลง Science Plan ที่ตรวจสอบแล้วเป็นโปรแกรมสังเกตการณ์

3. ### **Use Case: Monitor the operation of the observation program**

**Description:** ผู้สังเกตการณ์เฝ้าติดตามการดำเนินการของโปรแกรมสังเกตการณ์

4. ### **Use Case: Manage Observing Program Schedule**

**Description:** ผู้สังเกตการณ์ตรวจสอบคิวการทำงานของโปรแกรมสังเกตการณ์ ถ้าต้องการสามารถปรับเปลี่ยนลำดับคิวได้

## **Telescope Operator**

1. ### **Use Case: Setup and inspection of telescopes**

**Description:** เจ้าหน้าที่ควบคุมกล้องโทรทรรศน์ตั้งค่าและตรวจสอบกล้องโทรทรรศน์ ถ้าเจอปัญหาต้องส่งรายงานแจ้งซ่อมผ่านระบบ

2. ### **Use Case: Control the operation of the telescope**

**Description:** เจ้าหน้าที่ควบคุมกล้องโทรทรรศน์ควบคุมการทำงานของกล้องโทรทรรศน์ระหว่างกำลังสังเกตการณ์ตามโปรแกรมสังเกตการณ์ โดยถ้าต้องการสามารถตั้งค่ากล้องระดับสูงได้และสลับโหมดการทำงานของกล้องได้

3. ### **Use Case: Monitor the operation of the telescope**

**Description:** เจ้าหน้าที่ควบคุมกล้องโทรทรรศน์เฝ้าสังเกตและดูข้อมูลการทำงานของกล้องโทรทรรศน์ระหว่างกำลังสังเกตการณ์ตามโปรแกรมสังเกตการณ์

## **Astronomer - Observer - Telescope Operator**

1. ### **Use Case: View results from the observation program**

**Description:** นักดาราศาสตร์, ผู้สังเกตการณ์ และเจ้าหน้าที่ควบคุมกล้องโทรทรรศน์ดูผลลัพธ์ที่ได้จากการดำเนินงานตามโปรแกรมสังเกตการณ์

## **Maintenance staff**

1. ### **Use Case: View repair report**

**Description:** Maintenance staff ดูรายงานการแจ้งซ่อมอุปกรณ์ ถ้ามีการซ่อมแซมให้ update สถานะการดำเนินการซ่อมแซม

2. ### **Use Case: Check and Set Up Equipment**

**Description:** Maintenance staff ตรวจสอบและตั้งค่าอุปกรณ์ ถ้าเจอปัญหาต้องรายงานไว้ในระบบ

3. ### **Use Case: Record the installation history of new equipment**

**Description:** Maintenance staff บันทึกประวัติและข้อมูลการติดตั้งอุปกรณ์ใหม่

4. ### **Use Case: Monitoring the system**

**Description:** Maintenance staff เฝ้าสังเกตการทำงานของระบบ Gemini ถ้าเจอ error ต้องรายงานข้อผิดพลาดไว้ในระบบ

5. ### **Use Case: Test the System and Run Test Commands**

**Description:** Maintenance staff ทดสอบระบบ Gemini และรันคำสั่งทดสอบ 

## 

## **Administrator**

1. ### **Use Case: Manage User Permissions and Roles**

**Description:** Admin จัดการสิทธิ์และบทบาทของผู้ใช้ ถ้ามีผู้ใช้ใหม่สามารถเพิ่มผู้ใช้ใหม่เข้าระบบ, สามารถแก้ไขสิทธิ์และบทบาทให้กับผู้ใช้เก่า และสามารถลบผู้ใช้ออกจากระบบ

2. ### **Use Case: Manage Maintenance Schedules**

**Description:** Admin จัดการตารางการบำรุงรักษาระบบ ถ้ามีงานใหม่สามารถเพิ่มลงตารางงานในระบบ, แก้ไขข้อมูลงานได้ และลบงานในตารางงานได้

