// Create a basic class with a default constructor
class Club {
  def symbol = "♣"
  override def toString = symbol
}
new Club // ♣
// Two clubs are not equal since we did not override 'equals' method:
new Club() == new Club() // false


// Create another class for all card suites with a case class:
case class Suite(symbol: String)
// We can instanciate this class via its constructor:
Suite("♣") // Suite(♣)
// We can also instanciate it via its 'apply' method
new Suite("♣") // Suite(♣)
// We can then compare similar objects since Java's 'equals' is already implemented, on all fields):
Suite("♣") == Suite("♣") // true


// Create an enumeration for all card suites with a "sealed case class" and a singleton:
object Suites {
  sealed case class EnumSuite(symbol: String)
  val CLUB = EnumSuite("♣")
  val DIAMOND = EnumSuite("♦")
  val HEART = EnumSuite("♥")
  val SPADE = Suite("♠")
  val values = Seq(CLUB, HEART, DIAMOND, SPADE)
}
// This way, there can only be 4 card suites since sealed classes cannot be instanciated elsewhere
Suites.CLUB != Suites.HEART // true
Suites.values // List(EnumSuite(♣), EnumSuite(♥), EnumSuite(♦), Suite(♠))

// Create a function that returns suite's color ("red" or "black") using pattern matching
def color(suite: Suite): String = suite match {
  case Suites.CLUB | Suites.SPADE => "black"
  case Suites.DIAMOND | Suites.HEART => "red"
}
color(Suites.SPADE) // black
