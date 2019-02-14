package tech.simter.auth.po

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import tech.simter.auth.ROLE_TABLE
import tech.simter.auth.po.base.Actor
import tech.simter.auth.po.base.PersistenceStatus
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit

/**
 * The permission that someone has in a organization.
 *
 * The [branch] and [code] should be global unique.
 *
 * @author RJ
 */
@Table(ROLE_TABLE)
data class Role(
  @Id override val id: Long,
  override val status: Role.Status,
  /** A convenient identity for program */
  override val code: String,
  override val name: String,
  /**
   * The belong to [Company].
   *
   * Null means this role is a common role for each [Company].
   */
  override val branch: Company? = null,
  override val createOn: OffsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)
) : Actor {
  override val type: Actor.Type
    get() = Actor.Type.Role

  /**
   * The Role Status.
   *
   * @author RJ
   */
  enum class Status(
    override val value: Short
  ) : PersistenceStatus {
    /** Can be used from now on */
    Enabled(1),
    /** Can not be used anymore */
    Disabled(2)
  }
}