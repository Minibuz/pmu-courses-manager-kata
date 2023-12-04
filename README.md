# Exercice technique v2
Dans le cadre de la modernisation du SI PMU vers une architecture événementielle, vous devez
développer un nouveau microservice responsable du cycle de vie d’une course et de ses partants
(chevaux).

Après un rude interrogatoire du métier, vous apprenez que :
- Une course a lieu un jour donné et possède un nom et un numéro unique pour ce jour ;
- Une course possède au moins 3 partants ;
- Chaque partant possède un nom et un numéro ;
- Les partants d’une course sont numérotés à partir de 1, sans doublon ni trou.

Pour le MVP on vous demande de développer une API permettant de créer des courses et leurs
partants, de stocker les informations en base de données et de les exposer au reste du SI par un
message publié sur un bus.

Les vils architectes vous imposent les contraintes suivantes :
- Application Spring Boot en Java
- Base de données SQL
- Bus Kafka

Cet exercice est réalisé en autonomie sans contrôle de temps mais il ne faudrait pas y investir plus de 2h.

Le livrable sera un ZIP du code source de votre application.

Le code développé servira de support de discussion lors du débrief. On attend du pragmatisme : une
architecture logicielle simple, mettant en avant les éléments clés attendus (validation, gestion de la
base de données, tests, documentation…).

A vous de jouer !