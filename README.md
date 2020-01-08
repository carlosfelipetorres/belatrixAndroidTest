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

## 4. Diseña un custom view de una brújula utilizando canvas y pon el código que utilizarías en esta sección.
