******** Simulateur de mouton de Charpy ********


***** A quoi sert le logiciel ? *****

Le simulateur de mouton de Charpy vous permet de simuler les
caractéristiques nécessaires d'un pendule pour permettre de casser
une éprouvette. Tout comme un véritable mouton de Charpy, vous
pourrez simuler la réaction du pendule lorsqu'il casse une éprouvette.

Le logiciel permet également de créer ses propres matériaux grâce à
une interface dédiée. Vous pouvez également les rentrer manuellement 
grâce au fichier BDMat.txt (voir dernier paragraphe).

Le logiciel permet également de simuler un pendule vide, il suffit de
créer un matériau avec une résilience nulle.

***** Comment utiliser le logiciel ? *****

Pour lancer le logiciel, il suffit de compiler et d'éxécuter le fichier
SimulateurCharpy.java

Si vous souhaitez fermer le programme, vous n'aurez qu'à cliquer sur la 
croix en haut à droite.

***** Recommandations *****

Pour que le logiciel fonctionne, il faut absolument que tous les fichiers
suivants soient présents :

- Dossier output
- Dessin.java
- Eprouvette.java
- Fenetre.java
- FenetreCreationMat.java
- Materiau.java
- Pendule.java
- SimulateurCharpy.java
- BDMat.txt

Pour une expérience optimale, nous vous recommandons d'utiliser un écran Full HD
soit une définition de 1920*1080.

Si vous souhaitez créer un matériau manuellement, voici la synthaxe à utiliser:
"Nom,résilience,rouge,bleu,vert,alpha".

Les valeurs "rouge", "bleu", "vert" et "alpha" doivent être comprises entre 0 et 255.
Attention à ne pas mettre d'espace en dehors du nom.
Veillez à ne pas laisser de ligne vide.
Si une erreur est présente dans ce fichier, le programme ne se lancera pas !