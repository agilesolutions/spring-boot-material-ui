import React from 'react'
import BaseComponent from './BaseComponent'

// Needed for onTouchTap
import injectTapEventPlugin from 'react-tap-event-plugin';
injectTapEventPlugin();

export default class Person extends BaseComponent {
  
  render() {
    const middle = (this.props.middle) ? <span itemProp="additionalName">{this.props.middle}</span> : '';

    return(
      <div className="Person">
        <div itemScope itemType="http://schema.org/Person">
          <span itemProp="givenName">{this.props.first}</span>
          {middle}
          <span itemProp="familiyName">{this.props.last}</span>
        </div>

        <div itemProp="email">{this.props.email}</div>
      </div>
    )
  }
}
