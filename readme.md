# Ris software

Sistema de prueba ris para Aplicaciones web para I4.0

## Que hacer al descargar el repo?

Primero lo que necesitas hacer es descargar tu rama(ya esta en el repo remoto) y para hacerlo, realiza lo siguiente:

```bash
git checkout -b {nombreDeTuRama} origin/{nombreDeTuRama}
# Ejemplo
git checkout -b enrique origin/enrique
git pull
```

> [!NOTE]
> Todas las ramas las tiene

## Como debo trabajar?

Cuando ya hayas hecho la descarga del proyecto y tambien hayas creado tu rama como sugeri en el punto anterior
deberas quedarte **siempre** en tu rama, para no generar conflictos en la rama principal(main). Para cambiar de rama se hace lo siguente:

```bash
git switch {nombreRama}
#Ejemplo
git switch enrique
```

## Que hago cuando quiera subir cambios?

Cuando quieras hacer cambios al repo hay dos opciones subir los cambios como ya saben o hacer una pull request. Lo recomendable seria hacer una pull request pero solo suban sus cambios a su rama de la siguiente forma:

```bash
#Tiene que estar en tu rama para hacer esto
git push -u origin {nombreRama}
#Ejemplo
git push -u origin enrique
```

Una vez hecho el pull **POR FAVOR INFORMAR PARA PODER REVISAR QUE SU CODIGO NO AFECTE A OTRAS PARTE DEL SISTEMA**
para poder hacer un merge de sus cambios realizados
