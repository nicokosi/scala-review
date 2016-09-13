class Club {
  val symbol = "♣"
  val label = "club"
}

val club: Club = new Club()
club.symbol // ♣

club.equals(club) // true
club == new Club // false
club.eq(new Club) // false
club.equals(new Club) // false


club // Club@1ac88f64
club.hashCode() // 1976061787
new Club().hashCode() // 1751431390

case class CardSuite(symbol: String, label: String)

new CardSuite("♣", "club") // CardSuite(♣,club)
CardSuite("♣", "club") // CardSuite(♣,club)

CardSuite("♣", "club").symbol
CardSuite("♣", "club") == CardSuite("♣", "club") // true
CardSuite("♣", "club").equals(CardSuite("♣", "club")) // true
CardSuite("♣", "club").eq(CardSuite("♣", "club")) // false
CardSuite("♣", "club").hashCode() // 1302714609
CardSuite("♣", "club").hashCode() // 1302714609

object CardSuites {
  val CLUB = CardSuite("♣", "club")
  val DIAMOND = CardSuite("♦", "diamond")
  val HEART = CardSuite("♥", "heart")
  val SPADE = CardSuite("♠", "spade")
  def values() = List(DIAMOND, HEART, SPADE, CLUB)
}
CardSuites.CLUB != CardSuites.DIAMOND // true
CardSuites.values // List(CardSuite(♦,diamond), CardSuite(♥,heart), CardSuite(♠,spade), CardSuite(♣,club))

def justColor(cardSuite: CardSuite): String = cardSuite match {
  case CardSuites.CLUB | CardSuites.SPADE => "black"
  case CardSuites.DIAMOND | CardSuites.HEART => "red"
  case _ => "none"
}

def describeColor(cardSuite: CardSuite): String = cardSuite match {
  case CardSuite(_, label) => s"$label is ${justColor(cardSuite)}"
}

justColor(CardSuites.SPADE) // black
describeColor(CardSuites.SPADE) // spade is black
