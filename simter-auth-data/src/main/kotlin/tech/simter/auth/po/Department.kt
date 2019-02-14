package tech.simter.auth.po

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import tech.simter.auth.DEPARTMENT_TABLE
import tech.simter.auth.po.base.Actor
import tech.simter.auth.po.base.Branch
import tech.simter.auth.po.base.Organization
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit

/**
 * A part of an organization that deals with a particular area of work.
 *
 * Its parent organization must be a [Company] or [Department].
 *
 * @author RJ
 */
@Table(DEPARTMENT_TABLE)
data class Department(
  @Id override val id: Long,
  override val status: Organization.Status,
  override val code: String,
  override val name: String,
  override val branch: Branch,
  override val createOn: OffsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)
) : Branch {
  override val type: Actor.Type
    get() = Actor.Type.Department
}