class SalesRouteSpec extends UnitSpec:
  trait context:
    given DataBase = DataBase.initialize
    val directSale = SalesRoute.Direct

  "#addAgent" should {
    "代理店をDBに追加できる" in new context:
      val name = "test"
      val updated = SalesRoute.addAgents(name)

      val agent = SalesRoute.Agent(name)
      assertResult(Seq(directSale, agent)) { updated.salesRoutes }

    "代理店を複数DBに追加できる" in new context:
      val names = Seq("代理店1号", "代理店2号", "代理店3号")
      val updated = SalesRoute.addAgents(names*)

      val agents = names.map(name => SalesRoute.Agent(name))
      assertResult(directSale +: agents) { updated.salesRoutes }
  }
