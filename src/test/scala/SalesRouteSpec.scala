class SalesRouteSpec extends UnitSpec:
  trait context:
    val dataBase = DataBase()
    val directSale = SalesRoute.Direct()

  "#addAgent" should {
    "代理店をDBに追加できる" in new context:
      val name = "test"
      val agent = SalesRoute.Agent(name)
      val updated = SalesRoute.addAgents(name)(dataBase)
      assertResult(Seq(directSale, agent)) { updated.salesRoutes }

    "代理店を複数DBに追加できる" in new context:
      val names = Seq("代理店1号", "代理店2号", "代理店3号")
      val agents = names.map(name => SalesRoute.Agent(name))
      val updated = SalesRoute.addAgents(names*)(dataBase)
      assertResult(directSale +: agents) { updated.salesRoutes }
  }
