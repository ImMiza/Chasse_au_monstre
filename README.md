# Chasse_au_monstre

Projet S2 pour le DUT Informatique

Développeurs:
- BOUKHEBZA Allan
- BASSARD Adrien
- DEFOSSEZ Aymeric
- WIEDER Hugo

Principe du jeu:
  Chasse au monstre est un jeu à 1/2 joueurs, contenant un plateau de jeu, un monstre et un chasseur.
  Le but du monstre est de parcourir toutes les cases du plateau de jeu sans se faire attraper par le chasseur.
  Le but du chasseur est d'attraper le monstre avant que celui-ci parcour tout le plateau de jeu.
  
Déroulement du jeu:
  Premièrement, avant de commencer la partie, le chasseur doit poser 3 pièges sur le plateau de jeu en entrant les coordonnées pour chacune.
 
  Ensuite, toujours avant de commencer la partie, le monstre lui doit définir où il souhaite commencer sur le plateau (il pourra choisir que aux extrémités du plateau)
 
  Une fois terminé, le jeu commence, sur le plateau nous pouvons voir plusieurs notations:
    M: Monstre
    P: Possible (les cases possibles de déplacements pour le monstre)
    C: Chasseur
    E: Effect (les cases avec un effet)
    V: Visité (les cases où le monstre est déjà passé)
  
  Le chasseur et le monstres vont joueur chacun leurs tours, le monstre se déplacera en entrant des coordonnées (et aux cases possibles autour de lui), et le chasseur rentrera lui aussi des coordonnées essayant de trouver le monstre.
  
  Si le chasseur trouve le monstre, il y aura un Pierre-Feuille-Ciseaux; si le chasseur gagne, alors le jeu est terminé. Si le monstre gagne, alors la partie continue laissant un déplacement au monstre pour s'enfuir
