# OrganizationCard

1. Открываем [docker-compose.yml](docker-compose.yml) - поднимаем psql
2. запускаем проект под профилем 'local'

API:
http://localhost:7070/webapp/directors - получить всех директоров
http://localhost:7070/webapp/organizations - Получить все организации
http://localhost:7070/webapp/filial-organizations - все филиалы

+ "/"{id}  - прибавляя к каждому api номер id (int) получим по нему сущность!  