# OrganizationCard

1. Открываем [docker-compose.yml](docker-compose.yml) - поднимаем psql
2. запускаем проект

API:
http://localhost:7070/webapp/directors - получить всех директоров
http://localhost:7070/webapp/organizations - Получить все организации (Реализован поиск по вхождению строки)
http://localhost:7070/webapp/filial-organizations - все филиалы

+ "/"{id}  - прибавляя к каждому api номер id (int) получим по нему сущность!  
