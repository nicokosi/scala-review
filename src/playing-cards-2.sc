object CardSuites extends Enumeration {
  type CardSuite = Value
  val CLUB, DIAMOND, HEART, SPADE = Value
}

import CardSuites.{CardSuite, CLUB, DIAMOND, HEART, SPADE}
def symbol(cardSuite: CardSuite) = cardSuite match {
  case CLUB => "♣"
  case DIAMOND => "♦"
  case HEART => "♥"
  case SPADE => "♠"
}
symbol(CLUB) // ♣

def color(cardSuite: CardSuite): String = cardSuite match {
  case CLUB | SPADE => "black"
  case DIAMOND | HEART => "red"
}
color(CLUB) // black

def describeColor(cardSuite: CardSuite): String =
  s"${symbol(cardSuite)} is ${color(cardSuite)}"

describeColor(SPADE) // ♠ is black
