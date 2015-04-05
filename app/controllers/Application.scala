package controllers

import play.api.Play.current
import scala.concurrent.ExecutionContext.Implicits.global

import play.api._
import play.api.libs.ws
import play.api.libs.ws.WS
import play.api.mvc._

import scala.concurrent.Future

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Hello world."))
  }

}