การติดตั้งโปรแกรม
มีการดาวน์โหลด fonts ที่ชื่อ Chonburi และ FC Active สามารถดาวน์โหลดได้ผ่าน 
	https://fonts.google.com/specimen/Chonburi
	https://www.f0nt.com/release/fc-active/ 
หรือสามารถคลิกติดตั้ง fonts ที่ให้ไปในโฟลเดอร์ fonts ได้เลยค่ะและวิธีการ run jar file สามารถ double click ที่ jar file ได้เลย ในกรณีที่เปิดไม่ได้โดยพิมพ์ใน command line ว่า
	java -jar 6210450610.jar
โดย jar file จะเก็บไว้ในโฟลเดอร์ project-6210450610

โครงสร้างไฟล์
Folder fonts : จะเก็บ fonts ที่ใช้ในงาน
Folder data : จะเก็บ CSV file ที่ใช้ในงานทั้งหมด
Folder src : จะเก็บ java class ทั้งหมดที่ใช้
   Folder main :
     Folder java :
       Package project : จะเก็บ Run.java และ package ของโค้ดทั้งหมดไว้ในนี้
         Package controllers : จะเก็บ java class ที่ควบคุมหน้า fxml ทั้งหมด
         Package manageData : จะเก็บ java class ที่ทำหน้าที่เขียนและอ่าน CSV file ทั้งหมดไว้ในนี้ 
         Package models : จะเก็บ java class ที่เกี่ยวกับผู้ดูแลระบบ เจ้าหน้าที่ส่วนกลาง ผู้เข้าพักและจดหมาย/เอกสาร/พัสดุ
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
commit ครั้งที่ 7 : ส่งโครงงานที่แก้ไขรอบที่ 1
commit ครั้งที่ 8 : ส่งโครงงานที่แก้ไขรอบที่ 1 แต่แก้ไขเนื่องจากการ commit ครั้งที่ 7 หา jar file ไม่เจอ
commit ครั้งที่ 9 : ส่งโครงงานที่แก้ไขรอบที่ 2

สิ่งที่แก้ไขในการส่งโครงงานรอบที่ 2
- มีการเปลี่ยนสี GUI ให้ใช้งานง่ายและสบายตามากขึ้น
- เขียนรายละเอียดของหน้าสร้างรายละเอียดผู้พักอาศัยใหม่ในไฟล์ pdf เพิ่มเติม เพื่ออธิบายให้ละเอียดมากขึ้น และมีการเพิ่มรูปภาพในการอธิบายคู่มือการใช้งาน
- มีการลบ package ที่อยู่ใน models ทั้งหมดทิ้งและนำออกมาอยู่นอก package ที่ลบทิ้งไปแล้ว
- มีการเปลี่ยนชื่อ java class ต่างๆ ให้เหมาะสมและทำการลบ java class ที่เก็บ list ต่างๆ ไปแล้วนำ method ที่อยู่ใน list ไปเรียกใช้ใน java class ที่มีอยู่แล้วแทน ลดการมี class ที่ไม่ได้ใช้งานเยอะเกินไปและได้แก้โค้ดที่เกี่ยวข้อง
- ในหน้าแสดงจดหมาย / เอกสาร / พัสดุของผู้เข้าพักแต่ละบุคคลที่ได้เข้าสู่ระบบ ได้เปลี่ยนแปลงตารางจากเดิมที่สามารถเห็นข้อมูลของผู้เข้าพักอื่นได้เป็นเห็นเฉพาะของผู้เข้าพักที่เข้าสู่ระบบคนนั้นคนเดียว
- แก้ไขโค้ดให้มีการใช้ superclass / subclass มากขึ้นและแก้การเป็น polymorphism ของโค้ด (มีการ new object ที่ทำให้เป็น polymorphism ใน RegisterGuest.java และใน RegisterStaff.java โดยการใช้ method addAccount)

สิ่งที่แก้ไขในการส่งโครงงานรอบที่ 3
- ทำการแยก class ของ ArrayList จาก AdminAccount.java StaffAccount.java และ GuestAccount.java
- แก้ไขการเป็น polymorphism ของโค้ด โดยแก้ใน ManageAdminFile.java ManageStaffFile.java และ ManageGuestFile.java เป็นส่วนใหญ่ ส่วนใน class อื่นๆ ที่มีการเรียกใช้ได้มีการเรียกใช้โดย superclass บ้างหรือมีการ casting
- ทำการแยก class ของ ArrayList ของ Thing มาสร้างเป็น class ThingList ใหม่แยกกัน
- ทำการใช้ polymorphism โดยเรียกใช้ superclass ใน controllers หน้าต่างๆ
