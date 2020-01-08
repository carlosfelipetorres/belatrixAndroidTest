# Belatrix Android Test

## 1. Propón los pasos, clases, layouts y recursos que utilizarías para hacer un Stepper reutilizable y que cumpla con los parámetros definidos en la guía de material design: https://material.io/archive/guidelines/components/steppers.html

Recursos:
- Drawables:
    Icono de "siguiente" y "atras".
    Icono de punto para la lista de puntos.
    Icono de "check" y "alert".
- Colors:
    Color de fondo
    Color de bottonNavBar
    Color de la fuente
- Dimens:
    Tamano de fuente
    Tamano de iconos
    Altura y ancho de botton banner
    Tamano de puntos 
    Tamano de progressbar
- Style: 
    Estilo de tabLayout
    Estilo de PagerView
    Estilo de Buttons
    Estilo de progressBar
    
Layouts: 
- Custom layout que contenga todos los elementos necesarios para crear la vista del Stepper:
    Un ViewPager. 
    Un TabLayout.
    Un ButtonNavBar que contenga los botones con sus iconos, el progressbar o lista de puntos.
    Un Fragment container.

Clases:
- Clases de los custom layouts:
    CustomViewPager.
    CustomTabLayout.
    CustomButtonNavBar.
    CustomFragmentContainer.
    CustomStepper (engloba todos los custom layouts para ser reutilizados)
    
- Clases adapters:
    StepperPagerAdapter.
    
- Clase example (donde se implementa el Stepper)
    Se declara la clase CustomStepper que recibe los pasos necesarios que se van a mostrar en un custom fragment container cada uno.
    
## 2. Crea un shake action en android y pon el código.
[Link a codigo](2nd_excercice/ShakerApplication/)

## 3. Explica cómo organizas en base a tu experiencia un proyecto en Android utilizando MVP e implementando Clean Architecture, menciona los paquetes que utilizarías y la distribución de módulos.

- Modulos:
    La app tiene 3 modulos, Presentation, Domain y Data. 
    
    - Data: 
    
    Dentro del modulo de Data se ubica la llamada a los servicios teniendo una interfaz que llama a los endpoints del backend (por ejemplo usando retrofit) y una clase que implementa una interfaz que se encuentra en el modulo de Domain, y que implementa sus metodos para recibir la respuesta del backend.
    
        - Dto: Paquete donde se incluyen las clases que mapean la respuesta del backend
        - Remote: Paquete donde se incluye la interfaz que llama a los servicios (retrofit)
        - Local: Paquete donde se incluiria la implementacion de una base de datos local (Room, SQLite, Realm)
    
    - Domain
    
    Dentro del modulo de domain se ubican los casos de uso, o interactors, de la aplicación. Tambien se ubica la interfaz que presenta estos interactors al modulo de Data.
    
        - Repository: Paquete donde se incluye la interfaz de los interactors o Casos de Uso.
        - Interactors: Paquete donde se ubica la implementacion de cada uno de los Casos de uso (Rx o Corrutinas)
        - Constants: Se incluyen las constantes de la aplicacion
        - Exceptions: Excepciones creadas para la recepcion de errores del backend y otros
        - Models: Clases que representan los objetos en la aplicacion, por ejemplo User, Country o Category.

    - Presentation:
    
    Dentro del modulo de Presentation se ubican los componentes de android que conforman la aplicacion y lo que ve el usuario. Por ejemplo Activities, Fragments entre otros. En este paquete se describe la arquitectura MVP. Dentro se divide los siguientes paquetes: 
    
        - Presenter: Incluye las clases que cumplen la funcion de presenter para cada modulo de la aplicacion. Hay un modulo por cada feature de la aplicacion por lo que habra un presenter para cada uno de ellos. Por ejemplo el modulo de Login tiene un LoginPresenter en este paquete. Cada Presenter implementa la interfaz que le permite comunicarse con la vista.
        
        - View: Este pequete incluye las vistas de cada uno de los modulos de la aplicacion, por ejemplo el modulo de Login tiene un LoginView. Esta clase mapea todos los elementos de la vista (XML de android) y se comunica con la Activity de android por diferentes mecanismos (por ejemplo un EventBus).
        
        - Base: Este paquete incluye las Activities y Fragments de Android. Cada una de estas activities tiene el rol de inicializar el view y el presenter de cada uno de sus modulos, y recibir los eventos que vengan del view (por ejemplo con el EventBus). 
        
        - Adapters: Incluye los adapters para las listas (RecyclerViews) u otros elementos (por ejemplo ViewPagers) que se utilicen dentro de la aplicacion. 

## 4. Diseña un custom view de una brújula utilizando canvas y pon el código que utilizarías en esta sección.
