enum SalesRoute:
  case Direct
  case Agent(name: String)

object SalesRoute:
  def addAgents(names: String*)(implicit dataBase: DataBase): DataBase =
    val agents: Seq[SalesRoute.Agent] =
      names.map(name => SalesRoute.Agent(name))
    dataBase.addAgents(agents*)
