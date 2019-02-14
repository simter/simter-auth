package tech.simter.auth.dto

import tech.simter.auth.po.Role
import tech.simter.auth.po.Team
import tech.simter.auth.po.User

/**
 * The authenticated data.
 *
 * @author RJ
 */
data class AuthenticatedData(
  /** [User.id] */
  val userId: Long,
  /** [User.code] */
  val userCode: String,
  /** [User.name] */
  val userName: String,
  /** [User.branch].id */
  val branchId: Long,
  /** [User.branch].type.value */
  val branchType: Short,
  /** [User.branch].code */
  val branchCode: String,
  /** [User.branch].name */
  val branchName: String,
  /** [User.company].id */
  val companyId: Long,
  /** [User.company].code */
  val companyCode: String,
  /** [User.company].name */
  val companyName: String,
  /** All [Role] codes this user owns */
  val roles: List<String>? = null,
  /** All [Team] codes this user join to */
  val teams: List<String>? = null
)