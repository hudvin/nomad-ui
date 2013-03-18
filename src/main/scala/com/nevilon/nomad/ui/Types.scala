package com.nevilon.nomad.ui

import javax.ws.rs.{Produces, Path, GET, PathParam}
import javax.ws.rs.core.MediaType
import java.util
import scala.collection.JavaConversions._
import collection.mutable.ListBuffer

@Path("/hello")
class HelloWorldService {

  @GET
  @Path("/{param}")
  @Produces(Array(MediaType.APPLICATION_XML))
  def getMsg(@PathParam("param") msg: String): util.List[Person] = {
    val people = new ListBuffer[Person]()
    people.add(new Person("vadim", "hudvin", 15))
    people.add(new Person("vadim", "hudvin", 20))
    people.add(new Person("vadim", "hudvin", 25))
    people
  }

}

import javax.xml.bind.annotation._

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
class Person(val name: String, val username: String, val age: Int) {

  def this() = this("", "", -1)

}