package tech.simter.auth.po.base

import tech.simter.auth.po.Company
import tech.simter.auth.po.Department
import tech.simter.auth.po.Team

/**
 * A Organization belongs to a parent Organization or it's a top Organization without parent..
 *
 * Organization is the abstraction of [Branch] ([Company] or [Department]) and [Team].
 *
 * @author RJ
 */
interface Organization : Actor {
  override val status: Organization.Status

  /**
   * The Organization Status.
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