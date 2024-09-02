# Fundamentos de Programacion II


## Laboratorio

Se debe tener instalado Java para abrir los programas y poder interpretarlos.

### Enunciado

Se trata de automatizar parte del sistema de gestión de la información que maneja una protectora de animales. Los requisitos del problema a resolver son los siguientes:

1. Una protectora de animales acoge animales perdidos o abandonados, proporcionándoles refugio, alimentación y asistencia sanitaria si la necesitara. Se considerará que dicha protectora recoge animales de dos tipos (perros y gatos). Cuando un animal es recogido, los voluntarios de la protectora le asignan un nombre, que será único, y que servirá para identificarlo en campañas de difusión (página web, redes sociales, etc), así como para la realización de todos los trámites relacionados con el animal (apadrinamiento, acogida, adopción, ...). De todos los animales interesará conocer su sexo (macho o hembra), edad (en años), si son sociables con las personas y si están apadrinados. En el caso de los perros, se necesita conocer su raza, tamaño (en kg), si pertenecen a la categoría ppp (perros potencialmente peligrosos) y si necesitan tratamiento para la enfermedad crónica leishmania. En el caso de los gatos, interesa conocer si están esterilizados.

2. Los animales de la protectora pueden recibir solicitudes de acogida y adopción. Para dar oportunidad a la acogida y adopción de todos los perros se admite un máximo de 10 solicitudes por animal.
   
3. La protectora dedica parte de su presupuesto a asumir los gastos veterinarios de los animales. Entre los gastos previstos de asistencia veterinaria se incluyen, en el caso de los perros, los gastos de tratamiento de la enfermedad de la leishmania, que supone un gasto por animal de 25 € mensuales, así como la vacuna anual de la rabia, que tiene un coste de 30 € por perro vacunado. Para poder suministrar la vacuna, en el caso de los perros catalogados como ppp y que tienen un carácter no sociable con las personas, es necesario la sedación del animal, la cual tiene un coste de 8 €. En el caso de los gatos, la protectora suministra un tratamiento de control del celo en las gatas no esterilizadas con un coste de 10 € mensuales. Todos estos gastos, en el caso de los animales apadrinados, son asumidos por los padrinos y no por la protectora. 

4. Cuando el dinero recaudado lo permite, se realizan campañas de esterilización de las gatas de la protectora, para lo cual una clínica veterinaria colabora ofreciendo un precio especial para dicha operación. De dicha clínica veterinaria interesa conocer su nombre, teléfono y precio de esterilización por gata. 

5. A principios de año el Ayuntamiento de la localidad concede una subvención consistente en una cantidad fija de 1000 € más otra cantidad que depende del número de animales en la protectora en el momento de conceder la subvención. De dicha administración interesa conocer el nombre de la persona de contacto, su teléfono y la cantidad de subvención que concede por animal recogido.

6. La mayor parte del presupuesto de la protectora se destina a la alimentación de los animales. La comida de los gatos es donada por una asociación extranjera. La comida de los perros cachorros (perros de 0 a 18 meses) es donada por una empresa de piensos de la localidad, la cual también ofrece precios especiales en la compra del pienso para perros adultos. Para la compra del pienso de los perros adultos se realiza la siguiente estimación: se considera que los perros pequeños (cuyo tamaño es inferior o igual a 15 kg) comen de media unos 200 gr. de pienso seco al día; los medianos (cuyo peso es superior a 15 kg y menor o igual a 25) comen de media 300 gr., mientras que los perros grandes (peso superior a los 25 kilos) necesitan comer aproximadamente el 1,5% de su peso. 

7. Se desea que el sistema permita realizar las siguientes consultas:

    1. Mostrar toda la información de los animales de la protectora (se proporcionará al alumno un fichero con la información de los animales).

   2. Se podrá realizar una solicitud de adopción o acogida de un animal.
   
   3. Consultar el listado de solicitudes de adopción de un animal.
   
   4. Calcular el coste de los gastos veterinarios previstos anuales que debería asumir la protectora, considerando a los animales recogidos en el momento de realizar la consulta.
   
   5. Calcular el coste de una campaña de esterilización de gatas, considerando a los animales que hay en la protectora en el momento de realizar la consulta.
   
   6. Calcular la estimación de la cantidad de pienso de perro adulto (en kg) para una semana, considerando a los animales que hay en la protectora en el momento de realizar la consulta.

   7. Calcula la subvención que concedería el Ayuntamiento, considerando a los animales que hay en la protectora en el momento de realizar la consulta.
   
8. Toda la interacción con el sistema deberá realizarse a través de un menú de opciones.

La información inicial de los animales recogidos por la protectora se proporciona en el fichero [“Animales.txt”](./Protectora/Animales.txt).

El programa no distinguirá entre mayúsculas y minúsculas.

Se deberán capturar, al menos, las siguientes excepciones:

1. Si el fichero “Animales.txt” no existe.

2. Si la selección de la opción del menú no está dentro del intervalo de opciones válidas. En tal caso, se deberá poder solicitar la opción de nuevo sin abandonar el programa.

3. Si, esperando un dato de tipo numérico, se recibe un dato no numérico.

4. Si se quiere registrar más de 10 solicitudes para un animal.
