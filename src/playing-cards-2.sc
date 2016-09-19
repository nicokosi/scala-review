object CardSuites extends Enumeration {
  type CardSuite = Value
  val CLUB, DIAMOND, HEART, SPADE = Value
}

def symbol(cardSuite: CardSuites.CardSuite) = cardSuite match {
  case CardSuites.CLUB => "♣"
  case CardSuites.DIAMOND => "♦"
  case CardSuites.HEART => "♥"
  case CardSuites.SPADE => "♠"
}
symbol(CardSuites.CLUB) // ♣

def justColor(cardSuite: CardSuites.CardSuite): String = cardSuite match {
  case CardSuites.CLUB | CardSuites.SPADE => "black"
  case CardSuites.DIAMOND | CardSuites.HEART => "red"
}
justColor(CardSuites.CLUB) // black

def describeColor(cardSuite: CardSuites.CardSuite): String =
  s"${symbol(cardSuite)} is ${justColor(cardSuite)}"

describeColor(CardSuites.SPADE) // ♠ is black
