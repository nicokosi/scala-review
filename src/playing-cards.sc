// Basic class
class Club {
  def symbol = "♣"
  override def toString = symbol
}
val club = new Club

// Less code, with a case class
case class Club2(symbol: String)
val club2 = Club2("♣")

// "Enum" with sealed case class
sealed case class Suite(symbol: String)
object Suites {
  val CLUB = Suite("♣")
  val HEART = Suite("♥")
  val DIAMOND = Suite("♦")
  val SPADE = Suite("♠")
}
val club3 = Suites.CLUB