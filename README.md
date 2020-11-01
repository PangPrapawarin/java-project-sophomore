การติดตั้งโปรแกรม
มีการดาวน์โหลด fonts ที่ชื่อ Chonburi และ FC Active สามารถดาวน์โหลดได้ผ่าน 
	https://fonts.google.com/specimen/Chonburi
	https://www.f0nt.com/release/fc-active/ 
หรือสามารถคลิกติดตั้ง fonts ที่ให้ไปในโฟลเดอร์ fonts ได้เลยค่ะและวิธีการ run jar file สามารถ double click ที่ jar file ได้เลย ในกรณีที่เปิดไม่ได้โดยพิมพ์ใน command line ว่า
	java -jar 6210450610.jar

โครงสร้างไฟล์
Folder fonts : จะเก็บ fonts ที่ใช้ในงาน
Folder data : จะเก็บ CSV file ที่ใช้ในงานทั้งหมด
Folder src : จะเก็บ java class ทั้งหมดที่ใช้
   Folder main :
     Folder java :
       Package project : จะเก็บ Main.java และ package ของโค้ดทั้งหมดไว้ในนี้
         Package controllers : จะเก็บ java class ที่ควบคุมหน้า fxml ทั้งหมด
         Package manageData : จะเก็บ java class ที่ทำหน้าที่เขียนและอ่าน CSV file ทั้งหมดไว้ในนี้ 
         Package models : จะเก็บ java class ที่ java class อื่นจะ inheritance ไปใช้และเก็บ package ของ java class ที่เกี่ยวกับผู้ดูแลระบบ เจ้าหน้าที่ส่วนกลาง ผู้เข้าพักและจดหมาย/เอกสาร/พัสดุ
           Package admin : จะเก็บ java class ที่เกี่ยวกับผู้ดูแลระบบทั้งหมด
           Package guest : จะเก็บ java class ที่เกี่ยวกับผู้เข้าพักทั้งหมด
           Package staff : จะเก็บ java class ที่เกี่ยวกับเจ้าหน้าที่ส่วนกลางทั้งหมด
           Package things : จะเก็บ java class ที่เกี่ยวกับจดหมาย/เอกสาร/พัสดุทั้งหมด
     Folder resources : เก็บข้อมูลที่ใช้แสดงใน jar file ทั้งหมด
         Folder photo : เก็บรูปที่ใช้ใน jar file
         Folder fxmlFile : เก็บ fxml file ทั้งหมดที่ใช้

สิ่งที่พัฒนาในแต่ละสัปดาห์
commit ครั้งที่ 1 : มีการเพิ่ม maven เข้าไปใน project และเริ่มออกแบบหน้าต่างแต่ละหน้า
commit ครั้งที่ 2 : มีการเชื่อมปุ่มแต่ละหน้า มีการเริ่มทำ controller ของแต่ละหน้า
commit ครั้งที่ 3 : มีการสร้าง class เกี่ยวกับจดหมาย/เอกสาร/พัสดุ และสร้าง class ในการเช็คบัญชีที่เข้าสู่ระบบ การใช้การสืบทอด interface ต่างๆ
commit ครั้งที่ 4 : มีการสร้างไฟล์ CSV การจัดเก็บบัญชีของเจ้าหน้าที่ส่วนกลาง
commit ครั้งที่ 5 : พัฒนา class ในแต่ละ class มีการเขียนโค้ดที่ใช้งานใน class ต่างๆ
commit ครั้งที่ 6 :  ไฟล์งานที่สมบูรณ์เรียบร้อย
