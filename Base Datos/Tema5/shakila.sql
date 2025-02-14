USE SAKILA;
-- 1. MUESTRA LA PELÍCULA MÁS LARGA
-- 2. MUESTRA LA PELÍCULA CON MENOR DURACIÓN
-- 3. MUESTRA LOS DISTINTOS RATING DE EDAD USADOS
-- 4. CUÁNTAS PELÍCULAS DURAN MÁS DE 2H
-- 5. MUESTRA EL NOMBRE DE LAS PELÍCULAS Y SU DURACIÓN EN HORAS (ORDENA DE MENOR A MAYOR DURACIÓN)
-- 6. ¿CUÁNTAS PELÍCULAS CONTIENEN ESCENAS ELIMINADAS?
-- 7. ¿QUÉ PELÍCULAS TIENEN "ALIEN" EN SU NOMBRE? (MUESTRA POR ORDEN ALFABÉTICO)
-- 8. ¿CUÁL ES LA PELÍCULA MÁS LARGA QUE PODEMOS VER POR MENOS DE 1$ (RENTAL_RATE)?
-- 9. ¿CUÁNTAS PELÍCULAS SON DOCUMENTALES? (COLUMNA DESCRIPTION)
-- 10. ¿CUÁL ES EL PRECIO DE REEMPLAZO MEDIO DE LAS PELÍCULAS CON RATING "R"?
-- 11. ¿CUÁNTOS DÍAS TARDARÍAMOS EN VER TODAS LAS PELÍCULAS? ¿Y AÑOS?
-- 12. ¿CUÁLES SON LAS TARIFAS DE ALQUILER (RENTAL RATE)?
-- 13. ¿CUÁNTAS PELÍCULAS DURAN MÁS DE 100 MINUTOS Y TIENEN UN RATING DE PG, R O G?
-- 14. ¿CUÁL ES LA PELÍCULA O PELÍCULAS CON MAYOR DURACIÓN DE LAS QUE CONTIENEN TRAILERS COMO EXTRAS?
-- 15. ¿QUÉ PELÍCULAS ESTÁN PROTAGONIZADAS POR UN ASTRONAUTA Y UN ADMINSTRADOR DE BASES DE DATOS (DESCRIPTION)?
-- 16. ¿CUÁNTO DURAN, DE MEDIA, LAS PELÍCULAS PROTAGONIZADAS POR EL ACTOR 1 (FILM_ACTOR)?
-- 17. ¿CUÁNTO TARDARÍAMOS (EN HORAS) EN VER TODAS LAS PELÍCULAS DE CATEGORÍA 6 (FILM_CATEGORY)?
-- 18. MUESTRA LOS PRECIOS DE ALQUILER (RENTAL_RATE) Y CUÁNTAS PELÍCULAS SE ALQUILAN DE CADA PRECIO.
-- 19. MUESTRA LA DURACIÓN MEDIA DE LAS PELÍCULAS AGRUPADAS POR RATING.
-- 20. MUESTRA LA DURACIÓN MEDIA DE LAS PELÍCULAS SIN ESCENAS ELIMINADAS AGRUPADAS POR RATING.
-- 21. ¿CUÁNTO NOS COSTARÍA REEMPLAZAR (REPLACEMENT_COST) LAS PELÍCULAS DE JENNIFER DAVIS (TABLA ACTOR Y FILM_ACTOR) SI VAMOS AL VIDEOCLUB Y LAS DESTRUIMOS?
-- 22. MUESTRA EL NOMBRE DE LAS PELÍCULAS EN MINÚSCULA
-- 23. CREA UN CÓDIGO CONCATENANDO LAS 4 PRIMERAS LETRAS DE CADA PELÍCULA Y LOS 2 ÚLTIMOS DÍGITOS DE LA FECHA DE LANZAMIENTO.
-- 24. IGUAL QUE EL ANTERIOR PERO EN MINÚSCULA
-- 25. CREA UN CÓDIGO DE ACTOR CONCATENANDO LAS 3 PRIMERAS LETRAS DEL NOMBRE Y LAS 3 PRIMERAS LETRAS DE LOS APELLIDOS DE CADA ACTOR Y DÁNDOLE LA VUELTA A LA CADENA. EN MINÚSCULA.
-- 26. MUESTRA LA DURACIÓN MEDIA DE LAS PELÍCULAS AGRUPADAS POR RATING (REDONDEA 2 DECIMALES)
-- 27. SUPONIENDO QUE RENTAL_DURATION ES LA DURACIÓN EN DÍAS DEL ALQUILER, Y QUE RENTAL_RATE ES EL PRECIO DIARIO DE CADA PELÍCULA, MUESTRA: EL NOMBRE DE LA PELÍCULA, LOS DÍAS DE ALQUILER, EL PRECIO DIARIO, EL PRECIO TOTAL Y UNA COLUMNA QUE DIGA CUÁNTOS BILLETES DE 10 DÓLARES NECESITARÍA PARA ALQUILARLA.
-- 28. SELECCIONA EL TÍTULO DE LAS PELÍCULAS, UNA COLUMNA QUE MUESTRE SI DURA MÁS O MENOS DE 2H, OTRA COLUMNA QUE MUESTRE SI TIENE O NO ESCENAS ELIMINADAS Y OTRA QUE MUESTRE SI TIENE O NO TRAILERS (COLUMNAS BOOLEANAS).
-- 29. SELECCIONA EL TÍTULO DE LAS PELÍCULAS Y UNA COLUMNA QUE MUESTRE SI LA PELÍCULA ES APTA PARA TODOS LOS PÚBLICOS (G, PG Y PG-13).
-- 30. SELECCIONA LA DURACIÓN MÁXIMA DE LAS PELÍCULAS AGRUPADAS POR RENTAL_DURATION.
-- 31. SELECCIONA EL COSTE DE REEMPLAZO MEDIO DE LAS PELÍCULAS AGRUPADAS POR DURACIÓN>120.
-- 32. ¿CUÁL ES EL ACTOR QUE MÁS PELÍCULAS HA HECHO? TABLAS ACTOR Y FILM_ACTOR (USA LIMIT 1).
-- 33. MUESTRA LAS CATEGORÍAS DE PELÍCULA (CÓDIGO DE CATEGORÍA) QUE HAY Y CUÁNTAS PELÍCULAS HAY DE CADA CATEGORÍA.
-- 34. MUESTRA LOS DISTINTOS AÑOS DE LANZAMIENTO PARA LOS QUE TENEMOS PELÍCULAS.
-- 35. MUESTRA EN MINÚSCULA EL NOMBRE Y LOS APELLIDOS DE LOS ACTORES QUE HAN HECHO MÁS DE 15 PELÍCULAS (CUENTA SOLO PELÍCULAS DE MÁS DE 100 MINUTOS).
-- 36. ¿CUÁL ES EL RENTAL_RATE MEDIO DE LAS PELÍCULAS EN LAS QUE APARECE UN FRISBEE?
-- 37. ¿QUÉ ACTOR HA PARTICIPADO EN MÁS PELÍCULAS CON FRISBEE? (USA LIMIT 1).
;
-- 38. SELECCIONA UNA LISTA DE LOS ACTORES (CONCATENA NOMBRE Y APELLIDOS) Y MUESTRA CUÁNTAS PELÍCULAS HA HECHO CADA ACTOR.
SELECT CONCAT(actor.first_name, " ", actor.last_name) as nombreActor,
    count(film_actor.actor_id) AS numeroPeliculas
FROM actor
    JOIN film_actor ON actor.actor_id = film_actor.actor_id
GROUP BY actor.actor_id;
-- 39. MUESTRA UNA LISTA DE LAS PELÍCULAS Y SU IDIOMA EN MAYÚSCULA.
SELECT film.title,
    UPPER(language.name)
FROM film
    JOIN language ON film.language_id = language.language_id
GROUP BY film_id
ORDER BY language.language_id;
-- 40. MUESTRA UNA LISTA DE LAS PELÍCULAS Y LA CANTIDAD DE CADA PELÍCULA QUE TENEMOS EN EL INVENTARIO.
SELECT film.title,
    count(inventory.film_id)
FROM film
    JOIN inventory ON film.film_id = inventory.film_id
GROUP BY film.title;
-- 41. MUESTRA EL NOMBRE Y LOS APELLIDOS DEL USUARIO QUE MÁS PELÍCULAS HA ALQUILADO.
SELECT CONCAT(cust.first_name, " ", cust.last_name) AS nombreCliente,
    COUNT(rental.rental_id) AS numeroDePeliculasAlquiladas
FROM customer AS cust
    JOIN rental ON cust.customer_id = rental.customer_id
GROUP BY cust.customer_id;
-- 42. MUESTRA UNA LISTA DE LAS CATEGORÍAS Y LA DURACIÓN MEDIA DE LAS PELÍCULAS DE CADA CATEGORÍA.
SELECT cat.name,
    AVG(film.length)
FROM category AS cat
    JOIN film_category AS fc ON fc.category_id = cat.category_id
    JOIN film ON fc.film_id = film.film_id
GROUP BY cat.category_id;
-- 43. MUESTRA LA DIRECCIÓN DE LAS TIENDAS Y CUÁNTAS PELÍCULAS HAY EN CADA UNA.
SELECT adr.address,
    COUNT(inv.film_id)
FROM address AS adr
    JOIN store ON adr.address_id = store.address_id
    JOIN inventory AS inv ON store.store_id = inv.store_id
GROUP BY adr.address_id;

-- 44. ¿CUÁL ES LA PELÍCULA DE LA QUE TENEMOS MÁS COPIAS?
SELECT film.title,
    count(inventory.film_id) AS cuantity
FROM film
    JOIN inventory ON film.film_id = inventory.film_id
GROUP BY film.title
ORDER BY cuantity DESC
LIMIT 1;

-- 45. MUESTRA LA DIRECCIÓN DE LAS TIENDAS Y CUÁNTO EN TOTAL HA FACTURADO CADA UNA.
SELECT adr.address,
    COUNT(payment.amount)
FROM address AS adr
    JOIN staff ON adr.address_id = staff.address_id
    JOIN payment ON staff.staff_id = payment.staff_id
GROUP BY adr.address_id;

-- 46. MUESTRA UNA LISTA DE LAS PELÍCULAS Y CUÁNTO HAN PAGADO DE MEDIA POR ALQUILARLAS.
SELECT film.title,
    AVG(payment.amount) AS cantidadPagadaPromedio
FROM film
    JOIN inventory ON film.film_id = inventory.film_id
    JOIN rental ON inventory.inventory_id = rental.inventory_id
    JOIN payment ON rental.rental_id = payment.rental_id
GROUP BY film.title;

-- 47. ¿CUÁL HA SIDO LA PELÍCULA MÁS RENTABLE?
SELECT film.title,
    AVG(payment.amount) AS cantidadPagadaPromedio
FROM film
    JOIN inventory ON film.film_id = inventory.film_id
    JOIN rental ON inventory.inventory_id = rental.inventory_id
    JOIN payment ON rental.rental_id = payment.rental_id
GROUP BY film.title
ORDER BY cantidadPagadaPromedio DESC
LIMIT 1;

-- 48. MUESTRA UNA LISTA DE LOS CLIENTES Y CUÁNTO DINERO HA GASTADO CADA UNO.
SELECT CONCAT(cust.first_name, " ", cust.last_name) AS nombreCliente,
    COUNT(payment.amount) AS cantidadPagada
FROM customer AS cust
    JOIN payment ON cust.customer_id = payment.customer_id
GROUP BY nombreCliente
ORDER BY cantidadPagada DESC;

-- 49. ¿QUIÉN HA SIDO EL CLIENTE MÁS RENTABLE?
SELECT CONCAT(cust.first_name, " ", cust.last_name) AS nombreCliente,
    COUNT(payment.amount) AS cantidadPagada
FROM customer AS cust
    JOIN payment ON cust.customer_id = payment.customer_id
GROUP BY nombreCliente
ORDER BY cantidadPagada DESC
LIMIT 1;

-- 50. ¿HAY ALGUNA PELÍCULA PARA LA QUE NO TENGAMOS NINGUNA COPIA?
-- 51. MUESTRA UNA LISTA DE LAS PELÍCULAS QUE NOS FALTAN EN LA TIENDA 2.
-- 52. ¿CUÁL ES EL ACTOR MÁS FAMOSO?
-- 53. ¿CUÁL ES LA PELÍCULA MÁS ALQUILADA EN LA TIENDA 2?
-- 54. ¿DESDE QUÉ PAÍS NOS HAN ALQUILADO MÁS PELÍCULAS?
-- 55. MUESTRA LA DIRECCIÓN DE CADA TIENDA Y LA CANTIDAD DE USUARIOS INACTIVOS.
-- 56. ¿CUÁNTOS USUARIOS SIN TELÉFONO TENEMOS?
-- 57. MUESTRA UN LISTADO DE LAS CATEGORÍAS Y CUÁNTO DINERO HEMOS GANADO CON CADA UNA DE ELLAS.