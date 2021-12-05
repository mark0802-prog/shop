sealed trait SalesRoute

object SalesRoute:
  case class Direct() extends SalesRoute
  case class Agent(name: String) extends SalesRoute

  def addAgents(names: String*)(implicit dataBase: DataBase): DataBase =
    val agents = names.map(name => SalesRoute.Agent(name))
    dataBase.addAgents(agents*)
