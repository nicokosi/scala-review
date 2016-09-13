class Trèfle {
  val symbole = "♣"
  val libellé = "trèfle"
}

val trèfle: Trèfle = new Trèfle()
trèfle.symbole // ♣

trèfle.equals(trèfle) // true
trèfle == new Trèfle // false
trèfle.eq(new Trèfle) // false
trèfle.equals(new Trèfle) // false


trèfle // Trèfle@1ac88f64
trèfle.hashCode() // 1976061787
new Trèfle().hashCode() // 1751431390

case class Enseigne(symbole: String, libellé: String)

new Enseigne("♣", "trèfle") // Enseigne(♣,trèfle)
Enseigne("♣", "trèfle") // Enseigne(♣,trèfle)

Enseigne("♣", "trèfle").symbole
Enseigne("♣", "trèfle") == Enseigne("♣", "trèfle") // true
Enseigne("♣", "trèfle").equals(Enseigne("♣", "trèfle")) // true
Enseigne("♣", "trèfle").eq(Enseigne("♣", "trèfle")) // false
Enseigne("♣", "trèfle").hashCode() // 1302714609
Enseigne("♣", "trèfle").hashCode() // 1302714609

object Enseignes {
  val TREFLE = Enseigne("♣", "trèfle")
  val CARREAU = Enseigne("♦", "carreau")
  val COEUR = Enseigne("♥", "coeur")
  val PIQUE = Enseigne("♠", "pique")
  def values() = List(CARREAU, COEUR, PIQUE, TREFLE)
}
Enseignes.TREFLE != Enseignes.CARREAU // true
Enseignes.values // List[Enseigne] = List(Enseigne(♦,carreau), Enseigne(♥,coeur), Enseigne(♠,pique), Enseigne(♣,trèfle))

def indiquerJusteLaCouleur(cardSuite: Enseigne): String = cardSuite match {
  case Enseignes.TREFLE | Enseignes.PIQUE => "noir"
  case Enseignes.CARREAU | Enseignes.COEUR => "rouge"
  case _ => "aucune"
}

def décrireLaCouleur(enseigne: Enseigne): String = enseigne match {
  case Enseigne(_, libellé) => s"$libellé is ${indiquerJusteLaCouleur(enseigne)}"
}

décrireLaCouleur(Enseignes.PIQUE) // pique est noir
indiquerJusteLaCouleur(Enseignes.PIQUE) // noir