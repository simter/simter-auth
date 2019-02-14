package tech.simter.auth.po

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import tech.simter.auth.COMPANY_TABLE
import tech.simter.auth.po.base.Actor
import tech.simter.auth.po.base.Branch
import tech.simter.auth.po.base.Organization
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit

/**
 * A company, unit, enterprise who is working for.
 *
 * Its parent organization must be a [Company] or its a top [Company] without parent.
 *
 * @author RJ
 */
@Table(COMPANY_TABLE)
data class Company(
  @Id override val id: Long,
  override val status: Organization.Status,
  override val code: String,
  override val name: String,
  override val branch: Company? = null,
  override val createOn: OffsetDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)
) : Branch {
  override val type: Actor.Type
    get() = Actor.Type.Company
}