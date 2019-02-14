package tech.simter.auth.po.base

import tech.simter.auth.po.Company
import tech.simter.auth.po.Department
import tech.simter.auth.po.Role
import tech.simter.auth.po.User
import java.time.OffsetDateTime

/**
 * The identity abstraction for [Organization], [User] and [Role].
 *
 * The [company] and [code] should be global unique.
 *
 * @author RJ
 */
interface Actor {
  val id: Long
  /** The actor type */
  val type: Type
  /** The actor status */
  val status: PersistenceStatus
  /** The actor code */
  val code: String
  /** The actor name */
  val name: String
  /**
   * The directly belong to Branch.
   *
   * It can be [Company] or [Department].
   * And it must be equals to [company] or be the descendant of [company].
   */
  val branch: Branch?
  /**
   * The first ancestor Company on the belong branch tree.
   */
  val company: Company?
  val createOn: OffsetDateTime

  /**
   * The actor type.
   *
   * @author RJ
   */
  enum class Type(
    override val value: Short
  ) : PersistenceStatus {
    Company(1),
    Department(2),
    Team(4),
    User(8),
    Role(16)
  }
}