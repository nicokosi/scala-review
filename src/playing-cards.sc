// Create a basic class with one field
class Club {
  val symbol = "♣"
}
// Getter:
val club: Club = new Club()
club.symbol // ♣
// Default 'toString':
club // Club@1ac88f64
// Default 'equals'
// Two clubs are not equal since we did not override 'equals' method:
club == new Club // false
club.eq(new Club) // false
club.equals(new Club) // false
// Default 'hashCode'
club.hashCode() // 1976061787
new Club().hashCode() // 1751431390

// Create another class for all card suites with a case class:
case class Suite(symbol: String)
// Constructor for free
// We can instanciate this class via its constructor:
Suite("♣") // Suite(♣)
// 'apply' constructor for free
// We can also instanciate it via its 'apply' method
new Suite("♣") // Suite(♣)
// Still has getters:
Suite("♣").symbol // ♣
// 'equals' for free
// We can then compare similar objects since Java's 'equals' is already implemented, on all fields):
Suite("♣") == Suite("♣") // true
Suite("♣").equals(Suite("♣")) // true
Suite("♣").eq(Suite("♣")) // false
// 'hashCode' for free:
Suite("♣").hashCode() // 1302714609
Suite("♣").hashCode() // 1302714609


// Create an enumeration for all card suites with a "sealed case class" and a singleton:
object Suites {
  sealed case class EnumSuite(symbol: String, label: String)
  val CLUB = EnumSuite("♣", "club")
  val DIAMOND = EnumSuite("♦", "diamond")
  val HEART = EnumSuite("♥", "heart")
  val SPADE = EnumSuite("♠", "spade")
  val values = Seq(CLUB, HEART, DIAMOND, SPADE)
}
// This way, there can only be 4 card suites since sealed classes cannot be instanciated elsewhere
Suites.CLUB != Suites.HEART // true
Suites.values // List(EnumSuite(♣), EnumSuite(♥), EnumSuite(♦), Suite(♠))

// Create a function that returns suite's color ("red" or "black") using pattern matching
import Suites.EnumSuite
def color(suite: EnumSuite): String = suite match {
  case EnumSuite("♣", label) => s"$label is black"
  case EnumSuite("♠", label) => s"$label is black"
  case EnumSuite(_, label) => s"$label is red"
}

color(Suites.SPADE)
