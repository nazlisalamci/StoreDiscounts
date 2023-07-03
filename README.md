Proje ayağa kaldırıldıktan sonra 

http://localhost:8070/api/2.0/order 

urline post isteği atarken body alanı aşağıda verilen gibi doldurulduğunda:

{
  "CustomerId": 1,
  "Products": [1, 2]
}

id'si 1 olan customer id'si 1 ve 2 olan productları almış olur.

http://localhost:8070/h2-console/ 

urlinde 
JDBC URL: jdbc:h2:file:./devdb
User Name:sa 
olarak giriş yapıldığında kayıtları görebilirsiniz.


