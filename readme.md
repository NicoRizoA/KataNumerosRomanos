# &nbsp;\_\_  \_   \_\_\_\_  \_\_\_\_\_\_   \_\_\_\_ 

# |  |/ ] /    ||      | /    |

# |  ' / |  o  ||      ||  o  |

# |    \\ |     ||\_|  |\_||     |

# |     ||  \_  |  |  |  |  \_  |

# |  .  ||  |  |  |  |  |  |  |

# |\_\_|\\\_||\_\_|\_\_|  |\_\_|  |\_\_|\_\_|

# &nbsp;                            

Proyecto Java para convertir números arábigos a romanos y viceversa, con validaciones de entrada y excepciones personalizadas.



Fase 1:



* Conversión entero → romano.



* Conversión romano → entero.



* Validaciones de rango y formato.



* Tests unitarios con casos básicos, combinados y border.



Tecnologías usadas:



* Java 17



* Maven



* JUnit 5 + AssertJ para tests



# --------------------------------------------



Como construir el proyecto desde cero y ponerlo en ejecución:


1\. Crear el proyecto en tu IDE



Abre tu IDE de preferencia



Crea un nuevo proyecto Maven.



Configura:



GroupId: org.romans



ArtifactId: KataNumerosRomanos



Selecciona Java 17 como JDK del proyecto.



2\. Configurar el gestor de dependencias



Abre el archivo pom.xml.



Agrega las dependencias necesarias:



JUnit 5 (org.junit.jupiter:junit-jupiter) para tests unitarios.



AssertJ (org.assertj:assertj-core) para aserciones más expresivas en tests.



Configura los plugins de Maven:



maven-compiler-plugin para compilar con Java 17.



maven-surefire-plugin para ejecutar los tests.



3\. Crear paquetes y clases



Organiza la estructura de paquetes:



Paquete principal: org.romans → ConvertidorNumerosRomanos.java



Paquete de excepciones: org.romans.exceptions → InvalidArabicNumberException.java, InvalidRomanNumeralException.java.



4\. Implementar la lógica principal



Escribir los métodos y lógica de la conversión dentro del objeto ConvertidorNumerosRomanos.java.



5\. Crear excepciones personalizadas y validaciones



Definir excepciones específicas para manejar errores esperados:



InvalidArabicNumberException para números arábigos inválidos.



InvalidRomanNumeralException para números romanos inválidos.



6\. Escribir tests unitarios



Crear tests con JUnit 5 y AssertJ en src/test/java/org/romans/ConvertidorNumerosRomanosTest.java.



Ejemplos:



Casos normales (1, 5, 10…)



Casos combinados (IV, IX, XXI…)



Border cases (mínimo y máximo, por ejemplo 1 y 3999)



Entradas inválidas y verificar excepciones.



Ejecutar los tests desde consola con: mvn clean test

Ejecutar clase de prueba desde consola con: mvn compile exec:java -Dexec.mainClass="org.romans.Main"

# 

# --------------------------------------------

# 

# Kata Números romanos

### Fase 1

Desarrollar un componente que permita convertir números enteros a romanos y viceversa según el siguiente esquema:

* 1 ➔ I
* 2 ➔ II
* 3 ➔ III
* 4 ➔ IV
* 5 ➔ V
* 9 ➔ IX
* 21 ➔ XXI
* 50 ➔ L
* 100 ➔ C
* 500 ➔ D
* 1000 ➔ M



En ambos métodos de conversión, el componente debe validar si se ingresa un valor no permitido y responder con una excepción personalizada.

**Plus Fase 1:** Aplicar TDD o al menos hacer Tests unitarios del componente probando al menos 2 border cases para cada método de conversión.



### Fase 2

Exponer el método del componente que convierte valores numéricos arábigos a romanos en un endpoint (GET)
Exponer el método del componente que convierte valores numéricos romanos a arábigos en un endpoint (GET)

**Plus Fase 2:** Aplicar TDD (Test de integración usando la suite de Spring).



### Requerimientos/Restricciones

**Fase 1 y 2:** Usar Java 17 o superior. Maven o Gradle para la gestión de dependencias.
Para los puntos plus de cada fase, en lo relacionado a la infraestructura de tests se pueden usar las siguientes herramientas JUnit5+Mockito o Spock y Spring Boot Testing.
**Fase 2:** Usar Spring boot 3+.

Completar y modificar este readme e incluirlo como parte del repositorio agregando detalles sobre cómo construir el proyecto desde cero y ponerlo en ejecución.

