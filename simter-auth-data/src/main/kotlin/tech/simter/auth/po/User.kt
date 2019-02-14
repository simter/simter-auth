package tech.simter.auth.po

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import tech.simter.auth.USER_TABLE
import tech.simter.auth.po.base.Actor
import tech.simter.auth.po.base.Branch
import tech.simter.auth.po.base.PersistenceStatus
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit

/**
 * The system User.
 *
 * @author RJ
 */
@Table(USER_TABLE)
data class User(
  @Id override val id: Long,
  override val status: User.Status,
  override val code: String,
  override val name: String,
  /**
   * The master directly [Branch].
   *
   * A User can directly belong to multiple branches, but only the master [Branch] record here.
   * Other belong to branches should be record to [Relation] with [Relation.Type.UserBranch].
   */
  override val branch: Branch? = null,
  override val createOn: OffsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)
) : Actor {
  override val type: Actor.Type
    get() = Actor.Type.User

  /**
   * The User Status.
   *
   * @author RJ
   */
  enum class Status(
    override val value: Short
  ) : PersistenceStatus {
    /** Employ someone to do a job officially */
    Hired(1),
    /** Give up a job or position by telling your employer that you are leaving */
    Resigned(2),
    /**  Leave your job or stop working because of old age or ill health */
    Retired(4),
    /** Remove someone from their job, especially because they have done something wrong */
    Dismissed(8)
  }
}