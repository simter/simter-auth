package tech.simter.auth.po

import org.springframework.data.relational.core.mapping.Table
import tech.simter.auth.RELATION_TABLE
import tech.simter.auth.po.base.Actor
import tech.simter.auth.po.base.Branch
import tech.simter.auth.po.base.PersistenceStatus
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit

/**
 * The Relation between Actor.
 *
 * The [type], [master] and [follower] should be global unique.
 *
 * @author RJ
 */
@Table(RELATION_TABLE)
data class Relation(
  val type: Type,
  val master: Actor,
  val follower: Actor,
  /** The [follower] order bellow same [type] and [master] */
  val sn: Short = 0,
  val createOn: OffsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)
) {
  /**
   * The [Relation] Type.
   *
   * @author RJ
   */
  enum class Type(
    override val value: Short
  ) : PersistenceStatus {
    /** The association between [Branch] and [User] except the [master Branch][User.branch] */
    BranchUser(1),
    /** The association between [Team] and [User] */
    TeamUser(2),
    /** The association between [Role] and [User] */
    RoleUser(4)
  }
}