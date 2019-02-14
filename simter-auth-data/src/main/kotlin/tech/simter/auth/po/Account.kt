package tech.simter.auth.po

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import tech.simter.auth.ACCOUNT_TABLE
import tech.simter.auth.po.base.PersistenceStatus
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit

/**
 * The system Account.
 *
 * The [username] should be global unique.
 *
 * @author RJ
 */
@Table(ACCOUNT_TABLE)
data class Account(
  @Id
  val id: Long,
  val status: Account.Status,
  val username: String,
  val password: String,
  val createOn: OffsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)
) {
  /**
   * The Account Status.
   *
   * @author RJ
   */
  enum class Status(
    override val value: Short
  ) : PersistenceStatus {
    /** Can login to the system */
    Enabled(1),
    /** Can not login to the system */
    Disabled(2)
  }
}