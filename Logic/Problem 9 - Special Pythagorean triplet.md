___
![[Problem 9]]
___

## Retos
- Encontrar los valores de a, b y c.
- Que los valores de a, b y c sean un Triplete Pitagórico.
- Que este bien optimizado para valores grandes y no hacer búsquedas 1 hasta `a + b + c`.

## Encontrar rangos de búsqueda de "C"
Para encontrar los valores de a, b y c tenemos la pista 1
$$a^{2}+b^{2}=c^{2}$$
como es un triangulo en los que se basa el teorema de Pitágoras podemos afirmar que `a < b < c`  por las propiedades del triangulo con esto podemos asumir que `a + b >= c` y que el máximo valor para C seria la mitad ya que `c < 1000 - c` lo que  da `c < 500` en el caso de `a + b + c = 1000`, también se puede decir que el máximo valor de C no puede superar a la suma de `a + b`, siempre será menor C y el producto de la suma de `a+b` siempre será mayor.

``` python
maxC = n/2 # en el caso de 1000 es 500
```

ahora porque el producto de `a + b` seria la mitad pues la respuesta que los valores máximos de a y b puedes ser iguales como un triángulos con dos lados iguales sigue siendo un triangulo rectángulo en el cual se puede sacar un tripleta pitagórica.

![[Pasted image 20240202123218.png]]

con esto podemos sacar muchas cosas por ejemplo el mínimo valor de C pero necesitamos las propiedades del triangulo rectángulo donde dos lados son iguales

![[Pasted image 20240202124631.png]]

el valor de C seria la hipotenusa del triangulo y para el caso de 1000 seria así
$$k+k+k\sqrt{ 2 } = 1000$$
y la formula para encontrar la hipotenusa ( C ) es:
$$c = a * \sqrt{ 2 }$$
ya que si vemos el teorema de Pitágoras:
$$c = \sqrt{ a^{2}+a^{2} }$$
$$c = \sqrt{ 2a^{2} }$$
$$c = a*\sqrt{ 2 }$$
y con todos los valores así **(recordar que a y b en este caso relajado son iguales así que b también es a)**
$$a+b+c*\sqrt{ 2 } = 1000$$
pero debemos despejar "a" **(que es el cateto)**
$$ a + a + c\sqrt{ 2 } = 1000$$
$$2a + c\sqrt{ 2 }=1000$$
$$a=\frac{1000-c\sqrt{ 2 }} {2}$$

volvemos a la formula para encontrar a C reemplazar el cateto "a"
$$ c = \frac{1000-c}{2} * \sqrt{ 2 }$$
y ahora las matemáticas hagan lo suyo para despejar C lo máximo posible
$$ c = \frac{(1000-c)* \sqrt{ 2 }}{2} $$
$$ 2c = (1000-c) * \sqrt{ 2 }$$
$$ 2c = 1000*\sqrt{ 2 } - c * \sqrt{ 2 }$$
$$ 2c = 1000\sqrt{ 2 } - c\sqrt{ 2 }$$
$$ 2c + c\sqrt{ 2 }  = 1000\sqrt{ 2 }$$
$$ c(2+\sqrt{ 2 }) = 1000\sqrt{ 2 }$$
$$ c = \frac{1000\sqrt{ 2 }}{(2+\sqrt{ 2 })}$$
$$ c = \frac{1000\sqrt{ 2 }}{(2+\sqrt{ 2 })} * \frac{2-\sqrt{ 2 }}{2-\sqrt{ 2 }}$$
Saltare la parte de la ratificación
$$c = 1000\sqrt{ 2 } - 1000$$
ahora con esto podemos cambiar el 1000 por cualquier número que queramos y asi tenemos los rango de C el mínimo y el máximo
``` python
min = n * 2**0.5 - n # 414.2 en el caso de 1000
max = n/2 # 500 en el caso de 1000
```
## Encontrar rangos de búsqueda de "A" y "C"
Para encontrar los valores de A y B debemos guiarnos de la idea de a y b sus valores máximos pueden ser iguales como vimos al encontrar los valores máximo y mínimo de C entonces podemos elegir entre a o b para hacer el calculo retemos el valor de C 
```python
minVal = sumABC - c
```
pero recordar que también el otro cateto y tomando la propiedades del triangulo `a<b<c` tenemos
```python
minVal = sumABC - c - (c-1)
```
pero esto puede dar un número negativo el cual no favorece al código así ponemos 1 si es negativo como valor mínimo
```python
minVal = max(1,sumABC - c (c-1))
```
para el valor máximo podemos partir la suma en tres partes por ejemplo si en 1000 seria `1000 / 3 = 333` redondeado pero necesitamos que cumpla con `a<b<c` con restarle 1 a al resultado y daría 332 que podemos poner como `332 < 333 < 334` y su suma`999` que no da 1000 pero esta muy cerca y se puede arreglar suman 1, en el caso de 12 seria `12 / 3 = 4` y daría `3 < 4 < 5` y su suma si da 12 por lo tanto es una buena condicional pero caso de que los lados del triangulo sean iguales entonces se tendría que dividir en dos y eligiendo cual de los dos valores es menor
```python
maxVal = min((n // 3) - 1, (n - c) // 2) + 1
```
ahora solo encontrar al otro lado del triangulo que puede ser mayor o igual y se resuelve viendo restando
```python
b = sumABC - c - a
```

## Comprobación
Para ver si es un Triplete Pitagórico solo de validar con el Teorema de Pitágoras
```python
a**2 + b**2 == c**2
```
Si en verdad solo queda devolver el valor de los tres lados multiplicados
```python
if a**2 + b**2 == c**2:
	retun a*b*c
```