# Access to Star Catalogues

### Use Case Description

| Use Case Name: Access to Star Catalogues | ID: UC1 | Importance Level: High |
| :---- | :---- | :---- |
| Primary Actor: **Science Observer** |  | Use Case Type: Essential |
| Stakeholders and Interests: **Science Observer:** ต้องการเข้าถึงข้อมูลจากฐานข้อมูลดาวเพื่อดูข้อมูลวัตถุท้องฟ้าซึ่งช่วยสำหรับการสังเกตการณ์  |  |  |
| Brief Description: **Science Observer** สามารถเข้าถึงฐานข้อมูลดาวผ่านระบบของ Gemini เพื่อเลือกและตรวจสอบข้อมูลของดาวที่ต้องการใช้ในการสังเกตการณ์ โดยข้อมูลที่เข้าถึงได้รวมถึงพิกัดตำแหน่ง, ความสว่าง, และคุณสมบัติอื่น ๆ ของดาว |  |  |
| Trigger: Science Observer ต้องการค้นหาข้อมูลของดาวเพื่อใช้ในกระบวนการสังเกตการณ์ Type: External |  |  |
| Relationships:    Association: Science Observer   Include: \-   Extend: \-   Generalization: \- |  |  |
| Normal Flow of Events: เลือกเมนู "Star Catalogues" ระบบแสดงข้อมูลแคตตาล็อกดาวจากฐานข้อมูล Science Observer ค้นหาดาวตามพารามิเตอร์ที่กำหนด (เช่น ชื่อ, ตำแหน่ง, ความสว่าง) ระบบแสดงผลรายการดาวที่ตรงกับคำค้นหา Science Observer เลือกดาวที่ต้องการดูข้อมูล  |  |  |
| Subflows: 4a. หากต้องการกรองข้อมูล สามารถเลือกพารามิเตอร์เพิ่มเติม เช่น สเปกตรัมหรือระยะทาง ระบบแสดงผลรายการดาวที่ตรงกับคำค้นหาและอยู่ในฟิลเตอร์ |  |  |
| Alternate/Exception Flow: 4a. ไม่มีดาวที่ตรงกับเงื่อนไขการค้นหา ระบบแจ้งเตือนและแนะนำให้ปรับพารามิเตอร์การค้นหา  |  |  |

### Activity Diagram

### Class Diagram

### Sequence Diagram

# Create an Observing Program

### Use Case Description

| Use Case Name: Create an Observing Program | ID: UC2 | Importance Level: High |
| :---- | :---- | :---- |
| Primary Actor: **Science Observer** |  | Use Case Type: Essential |
| Stakeholders and Interests: **Science Observer:** ต้องการแปลงแผนวิทยาศาสตร์ให้เป็นโปรแกรมสังเกตการณ์ที่สามารถดำเนินการได้จริง **Astronomer:** ต้องการให้ข้อมูลจากแผนวิทยาศาสตร์ถูกนำไปใช้ในการสร้างโปรแกรมสังเกตการณ์ได้อย่างถูกต้อง  |  |  |
| Brief Description: **Science Observer** ทำการแปลงแผนวิทยาศาสตร์ที่ได้รับการตรวจสอบแล้วให้เป็นโปรแกรมสังเกตการณ์ (Observing Program) ซึ่งสามารถนำไปใช้ดำเนินการสังเกตการณ์ได้จริง |  |  |
| Trigger: Science Observer ต้องการสร้างโปรแกรมสังเกตการณ์จากแผนวิทยาศาสตร์ที่ได้รับการอนุมัติ Type: External |  |  |
| Relationships:   Association: Science Observer   Include: \-   Extend: \-   Generalization: \- |  |  |
| Normal Flow of Events: Science Observer เลือกแผนวิทยาศาสตร์ที่ผ่านการตรวจสอบแล้วและต้องการแปลงเป็น Observing Program ระบบแสดงข้อมูลแผนวิทยาศาสตร์ Science Observer กดปุ่มสร้างโปรแกรมสังเกตการณ์ Science Observer กำหนดค่าพารามิเตอร์ เช่น Movement Lens Focus Special equipment กดปุ่ม Confirm เพื่อสร้างโปรแกรมสังเกตการณ์ ระบบตรวจสอบความสอดคล้องของค่าที่กำหนดกับข้อจำกัดของกล้องโทรทรรศน์ หากค่าที่กำหนดสอดคล้องกับข้อจำกัด ระบบจะบันทึกโปรแกรมสังเกตการณ์ ระบบแสดงข้อมูลโปรแกรมการสังเกตการณ์ที่ได้รับการยืนยัน  |  |  |
| Subflows: \-  |  |  |
| Alternate/Exception Flow: 6a.หากค่าพารามิเตอร์ที่กำหนดไม่เป็นไปตามข้อกำหนดของระบบ  ระบบจะนะนำค่าที่เหมาะสมให้กับ Science Observer  Science Observer แก้ไขค่าตามคำแนะนำ |  |  |

### Activity Diagram

### Class Diagram

### Sequence Diagram

# Execute an Approved Science Plan

### Use Case Description

| Use Case Name: Execute an Approved Science Plan | ID: UC3 | Importance Level: High |
| :---- | :---- | :---- |
| Primary Actor: **Science Observer** |  | Use Case Type: Essential |
| Stakeholders and Interests: **Science Observer:** ต้องการดำเนินการตามแผนวิทยาศาสตร์ที่ได้รับอนุมัติให้สำเร็จตามที่กำหนด **Astronomer:** ต้องการให้แผนการสังเกตการณ์ดำเนินไปอย่างถูกต้องเพื่อให้ได้ข้อมูลทางดาราศาสตร์ที่มีคุณภาพ  |  |  |
| Brief Description: **Science Observer** ทำการดำเนินแผนวิทยาศาสตร์ที่ได้รับอนุมัติ ซึ่งรวมถึงการเริ่มต้นกระบวนการสังเกตการณ์ ควบคุมกล้องโทรทรรศน์ และเก็บข้อมูลดาราศาสตร์ตามที่กำหนดไว้ในแผน |  |  |
| Trigger: Science Observer ต้องการดำเนินงานแผนวิทยาศาสตร์ที่ได้รับอนุมัติ Type: External |  |  |
| Relationships:   Association: Science Observer   Include: \-   Extend: \-   Generalization: \- |  |  |
| Normal Flow of Events: Science Observer เลือกแผนวิทยาศาสตร์ที่ได้รับอนุมัติ Science Observer เลือกโปรแกรมสังเกตการณ์ที่ได้รับอนุมัติ ระบบตรวจสอบความพร้อมของอุปกรณ์และเงื่อนไขสังเกตการณ์ หากทุกอย่างพร้อม Science Observer สั่งให้ระบบเริ่มต้นการสังเกตการณ์ ระบบควบคุมกล้องโทรทรรศน์และอุปกรณ์ที่เกี่ยวข้องให้ทำงานตามแผน ระบบบันทึกข้อมูลที่ได้ระหว่างการสังเกตการณ์ |  |  |
| Subflows: 5a. Science Observer ต้องการปรับเปลี่ยนการตั้งค่าการสังเกตการณ์ระหว่างดำเนินการ Science Observer ป้อนค่าการตั้งค่าใหม่ เช่น มุมมอง, การเปิดรับแสง, ฟิลเตอร์ ระบบบันทึกการเปลี่ยนแปลงในการตั้งค่า ระบบปรับการตั้งค่ากล้องโทรทรรศน์และอุปกรณ์ตามค่าที่ได้รับ  |  |  |
| Alternate/Exception Flow: 3a.หากอุปกรณ์ใด ๆ ไม่สามารถใช้งานได้  ระบบจะแจ้งเตือน Science Observer Science Observer สามารถเลือกเปลี่ยนอุปกรณ์หรือเลื่อนเวลาการสังเกตการณ์ ระบบบันทึกการเปลี่ยนแปลง |  |  |

### Activity Diagram

### Class Diagram

### Sequence Diagram

# Monitor the Progress of Science Plan Execution

### Use Case Description

| Use Case Name: Monitor the Progress of Science Plan Execution | ID: UC4 | Importance Level: High |
| :---- | :---- | :---- |
| Primary Actor: **Science Observer** |  | Use Case Type: Essential |
| Stakeholders and Interests: **Science Observer:** ต้องการติดตามความคืบหน้าของการดำเนินการตามแผนวิทยาศาสตร์เพื่อให้แน่ใจว่าทำงานได้อย่างถูกต้อง **Astronomer:** ต้องการให้แน่ใจว่าแผนได้รับการดำเนินการอย่างเหมาะสม **Telescope Operator:** อาจต้องใช้ข้อมูลจากการ monitor เพื่อปรับการตั้งค่ากล้องโทรทรรศน์  |  |  |
| Brief Description: **Science Observer** ทำหน้าที่ตรวจสอบความคืบหน้าของการดำเนินการตามแผนวิทยาศาสตร์โดยใช้เครื่องมือมอนิเตอร์ของระบบ เพื่อตรวจจับข้อผิดพลาดหรือความผิดปกติในการดำเนินการและดำเนินการแก้ไขหากจำเป็น |  |  |
| Trigger: การเริ่มดำเนินการตามแผนวิทยาศาสตร์ที่ได้รับอนุมัติ Type: External |  |  |
| Relationships:   Association: Science Observer   Include: \-   Extend: \-   Generalization: \- |  |  |
| Normal Flow of Events: ระบบแสดงรายการแผนวิทยาศาสตร์ที่กำลังดำเนินการ Science Observer เลือกแผนที่ต้องการตรวจสอบ ระบบแสดงข้อมูลความคืบหน้า รวมถึงสถานะของกล้องโทรทรรศน์และอุปกรณ์ที่เกี่ยวข้อง Science Observer ตรวจสอบความถูกต้องของกระบวนการ หากพบความผิดปกติ หากสามารถแก้ไขได้ → Science Observer ดำเนินการแก้ไขเองได้เลย เช่น การปรับค่าพารามิเตอร์ของระบบ หากต้องการความช่วยเหลือเพิ่มเติม → ดำเนินการแจ้งเตือน Telescope Operator ระบบ logs event ที่เกิดขึ้น |  |  |
| Subflows: 5a.หากพบข้อผิดพลาดที่ Science Observer ต้องการความช่วยเหลือเพิ่มเติม → ส่งแจ้งเตือนไปยัง Telescope Operator Science Observer เลือกตัวเลือก “แจ้ง Telescope Operator” Science Observer กรอกรายละเอียดที่ต้องการแจ้งให้ Telescope Operator ทราบและแก้ไข ระบบส่งการแจ้งเตือนไปยัง Telescope Operator  |  |  |
| Alternate/Exception Flow: 5a. พบข้อผิดพลาดร้ายแรงที่ต้องแจ้งเตือนทันที ระบบตรวจพบข้อผิดพลาดร้ายแรง เช่น กล้องโทรทรรศน์ขัดข้อง ระบบแจ้งเตือน Science Observer อัตโนมัติ ระบบส่งข้อความฉุกเฉินไปยัง Telescope Operator อัตโนมัติ |  |  |

### Activity Diagram

### Class Diagram

### Sequence Diagram

# Collect Astronomical Data

### Use Case Description

| Use Case Name: Collect Astronomical Data | ID: UC5 | Importance Level: High |
| :---- | :---- | :---- |
| Primary Actor: **Science Observer** |  | Use Case Type: Essential |
| Stakeholders and Interests: **Science Observer:** ต้องการรวบรวมข้อมูลทางดาราศาสตร์อย่างถูกต้องเพื่อใช้ในการวิเคราะห์ทางวิทยาศาสตร์ **Astronomer:** ต้องการข้อมูลที่มีคุณภาพสูงเพื่อการวิเคราะห์และวิจัย |  |  |
| Brief Description: **Science Observer** ทำหน้าที่ควบคุมการรวบรวมข้อมูลทางดาราศาสตร์จากกล้องโทรทรรศน์และอุปกรณ์ที่เกี่ยวข้อง โดยตรวจสอบข้อมูลที่ได้เพื่อให้สามารถนำไปใช้วิเคราะห์ทางดาราศาสตร์ได้ |  |  |
| Trigger: การเริ่มดำเนินการตามแผนวิทยาศาสตร์ที่ได้รับอนุมัติ Type: External |  |  |
| Relationships:   Association: Science Observer   Include: \-   Extend: \-   Generalization: \- |  |  |
| Normal Flow of Events: Science Observer สั่งให้ระบบเริ่มต้นการสังเกตการณ์ ระบบควบคุมกล้องโทรทรรศน์และอุปกรณ์ที่เกี่ยวข้องให้ทำงานตามแผน ระบบบันทึกข้อมูลทางดาราศาสตร์ที่ได้จากกล้องโทรทรรศน์เซ็นเซอร์ที่เกี่ยวข้อง ระบบแสดงข้อมูลทางดาราศาสตร์ที่ได้จากการสังเกตการณ์แบบเรียลไทม์ Science Observer ดูข้อมูลทางดาราศาสตร์แบบเรียลไทม์ ระบบเสร็จสิ้นการสังเกตการณ์ตามแผน ระบบแสดงข้อมูลทางดาราศาสตร์ทั้งหมดที่ได้จากการสังเกตการณ์ Science Observer ดูข้อมูลทางดาราศาสตร์ทั้งหมดที่ได้ |  |  |
| Subflows: \-  |  |  |
| Alternate/Exception Flow: 4a. ข้อมูลทางดาราศาสตร์ไม่สามารถแสดงได้แบบเรียลไทม์ ระบบตรวจพบปัญหาด้านการเชื่อมต่อหรือการประมวลผล ระบบแจ้งเตือน Science Observer เกี่ยวกับความล่าช้าในการแสดงผล Science Observer ตัดสินใจดำเนินการแก้ไข เช่น รอให้ระบบแก้ไขอัตโนมัติ หรือเริ่มต้นการสังเกตการณ์ใหม่ 6a. การสังเกตการณ์ต้องหยุดก่อนกำหนด เช่น สภาพอากาศไม่เอื้ออำนวย หรืออุปกรณ์ขัดข้อง ระบบแจ้งเตือน Science Observer ระบบบันทึกข้อมูลล่าสุดที่สามารถบันทึกได้ |  |  |

### Activity Diagram

### Class Diagram

### Sequence Diagram

